package com.mediaid.mediaid.service.implement;

import com.mediaid.mediaid.DTO.form.formDangKy.FormDangKy;
import com.mediaid.mediaid.DTO.form.formDangKy.NguoiGiamHoDTO;
import com.mediaid.mediaid.DTO.form.formDangNhap.DangNhapDTO;
import com.mediaid.mediaid.constant.CommonConstant;
import com.mediaid.mediaid.model.*;
import com.mediaid.mediaid.repository.*;
import com.mediaid.mediaid.service.abstracts.AuthenticationService;
import com.mediaid.mediaid.util.CommonUtil;
import com.mediaid.mediaid.util.DecodeEncodeUtil;
import com.mediaid.mediaid.util.JwtHandler;
import com.mediaid.mediaid.util.ValidationUtil;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.UUID;

@Service
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    GenderRepo genderRepo;
    @Autowired
    DanTocRepo danTocRepo;
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    SoKhamRepo soKhamRepo;
    @Autowired
    NguoiGiamHoRepo nguoiGiamHoRepo;
    @Autowired
    DecodeEncodeUtil decodeEncodeUtil;
    @Autowired
    RoleRepo roleRepo;

    @Autowired
    LoiSongNguoiBenhRepo loiSongNguoiBenhRepo;

    @Override
    @Transactional
    public ResponseEntity<?> registry(FormDangKy registryForm, BindingResult bindingResult) {
        HashMap<String,String> errors = ValidationUtil.validationCheckBindingResult(bindingResult);
        if (!CommonUtil.isNullOrEmpty(errors)){
            log.warn(errors.toString());
            return ResponseEntity.badRequest().body(errors);
        }
        GioiTinh gioiTinh;
        DanToc danToc;
        Role role;
        TaiKhoan taiKhoan;
        try {
            taiKhoan = accountRepo.findByCccdCmt(registryForm.getCccdCmt());
            if (!CommonUtil.isNullOrEmpty(taiKhoan)){
                log.warn("CMT đã đăng ký tài khoản trên hệ thống");
                return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "CMT đã đăng ký trên hệ thống"));
            }
            taiKhoan = accountRepo.findBySdt(registryForm.getSdt());
            if (!CommonUtil.isNullOrEmpty(taiKhoan)){
                log.warn("SDT đã đăng ký tài khoản trên hệ thống");
                return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "SDT đã đăng ký trên hệ thống"));
            }
            gioiTinh = genderRepo.findByGioiTinhID(registryForm.getGioiTinhID());
            danToc = danTocRepo.findByDanTocID(registryForm.getDanTocID());
            role = roleRepo.findByRoleId(CommonConstant.ROLE_BENH_NHAN_ID);
        }catch (Exception e){
            log.error(String.valueOf(e));
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error"));
        }

        if(CommonUtil.isNullOrEmpty(gioiTinh) || CommonUtil.isNullOrEmpty(danToc)){
            log.warn("Invalid gioiTinhID or danTocID");
            return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid gioiTinhID or danTocID"));
        }
        try {
            String decodePassword = decodeEncodeUtil.encryptAES(registryForm.getMatKhau());
            //taiKhoan = registryForm.convertToEntity(registryForm, gioiTinh, danToc, decodePassword);
            taiKhoan = new TaiKhoan();
            taiKhoan.setGioiTinh(gioiTinh);
            taiKhoan.setMatKhau(decodePassword);
            taiKhoan.setNgaySinh(CommonUtil.parseStringToLocalDate(registryForm.getNgaySinh()));
            taiKhoan.setDanToc(danToc);
            taiKhoan.setRole(role);
            taiKhoan.setTen(registryForm.getTen());
            taiKhoan.setSdt(registryForm.getSdt());
            taiKhoan.setCccdCmt(registryForm.getCccdCmt());
            taiKhoan.setDiaChi(registryForm.getDiaChi());
            taiKhoan.setEmail(registryForm.getEmail());
            taiKhoan.setAccountID(UUID.randomUUID().toString());
            taiKhoan = accountRepo.save(taiKhoan);
        }catch (Exception e){
            log.error(String.valueOf(e));
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error"));
        }
        SoKham soKham = new SoKham();
        soKham.setSoKhamID(UUID.randomUUID().toString());
        soKham.setBhyt(registryForm.getBhyt());
        soKham.setTaiKhoan(taiKhoan);
        try {
            soKham = soKhamRepo.save(soKham);
        }catch (Exception e){
            log.error("Get data from database fail");
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error"));
        }
        LoiSongNguoiBenh loiSongNguoiBenh = new LoiSongNguoiBenh();
        loiSongNguoiBenh.setLoiSongNguoiBenhID(UUID.randomUUID().toString());
        loiSongNguoiBenh.setSoKham(soKham);
        try {
            loiSongNguoiBenhRepo.save(loiSongNguoiBenh);
        }catch (Exception e){
            log.error("Get data from database fail");
        }
        NguoiGiamHoDTO nguoiGiamHoDTO = new NguoiGiamHoDTO(registryForm.getTenNguoiGiamHo(), registryForm.getCccdCmtNguoiGiamHo(), registryForm.getMoiQuanHe(), registryForm.getSdtNguoiGiamHo());
        NguoiGiamHo nguoiGiamHo = nguoiGiamHoDTO.convertToEntity(nguoiGiamHoDTO);
        nguoiGiamHo.setGiamHoID(UUID.randomUUID().toString());
        nguoiGiamHo.setSoKham(soKham);
        try {
            nguoiGiamHoRepo.save(nguoiGiamHo);
        }catch (Exception e){
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error"));
        }
        log.info("Registry successfully");
        return ResponseEntity.ok().body(CommonUtil.returnMessage("message", "Registry successfully"));
    }

    @Override
    public ResponseEntity<?> login(DangNhapDTO dangNhapDTO, BindingResult bindingResult) {
        HashMap<String,String> errors = ValidationUtil.validationCheckBindingResult(bindingResult);
        if (!CommonUtil.isNullOrEmpty(errors)){
            log.warn(errors.toString());
            return ResponseEntity.badRequest().body(errors);
        }
        try {
            String decodePassword = decodeEncodeUtil.encryptAES(dangNhapDTO.getPassword());
            TaiKhoan taiKhoan = accountRepo.findByCccdCmtAndMatKhau(dangNhapDTO.getCmt(), decodePassword);
            if(!CommonUtil.isNullOrEmpty(taiKhoan)){
                String token = JwtHandler.generateJWT(taiKhoan.getAccountID());
                HashMap<String, String> response = CommonUtil.returnMessage("token", token);
                response.put("accountID", taiKhoan.getAccountID());
                response.put("soKhamID", taiKhoan.getSoKham().getSoKhamID());
                log.info("Login successfully");
                return ResponseEntity.ok().body(response);
            }
            log.info("Login fail, personalIdentifier or password");
            return ResponseEntity.ok().body(CommonUtil.returnMessage("message", "Login fail"));
        }catch (Exception e ){
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error"));
        }
    }
}
