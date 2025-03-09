package com.mediaid.mediaid.service.implement;

import com.mediaid.mediaid.DTO.form.RegistryForm;
import com.mediaid.mediaid.model.*;
import com.mediaid.mediaid.repository.*;
import com.mediaid.mediaid.service.abtract.RegistryService;
import com.mediaid.mediaid.util.CommonUtil;
import com.mediaid.mediaid.util.DecodeEncodeUtil;
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
public class RegistryServiceImpl implements RegistryService {
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

    @Override
    @Transactional
    public ResponseEntity<?> registry(RegistryForm registryForm, BindingResult bindingResult) {
        HashMap<String,String> errors = ValidationUtil.validationCheckBindingResult(bindingResult);
        if (!CommonUtil.isNullOrEmpty(errors)){
            log.warn(errors.toString());
            return ResponseEntity.badRequest().body(errors);
        }
        GioiTinh gioiTinh;
        DanToc danToc;
        try {
            gioiTinh = genderRepo.findByGioiTinhID(registryForm.getGioiTinhID());
            danToc = danTocRepo.findByDanTocID(registryForm.getDanTocID());
        }catch (Exception e){
            log.error(String.valueOf(e));
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error"));
        }

        if(CommonUtil.isNullOrEmpty(gioiTinh) || CommonUtil.isNullOrEmpty(danToc)){
            log.warn("Invalid gioiTinhID or danTocID");
            return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid gioiTinhID or danTocID"));
        }
        Account account;
        try {
            String decodePassword = DecodeEncodeUtil.encryptAES(registryForm.getMatKhau());
            account = registryForm.convertToEntity(registryForm, gioiTinh, danToc, decodePassword);
            account.setAccountID(UUID.randomUUID().toString());
            account = accountRepo.save(account);
        }catch (Exception e){
            log.error(String.valueOf(e));
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error"));
        }
        SoKham soKham = new SoKham();
        soKham.setSoKhamID(UUID.randomUUID().toString());
        soKham.setBhyt(registryForm.getBhyt());
        soKham.setAccount(account);
        try {
            soKham = soKhamRepo.save(soKham);
        }catch (Exception e){
            log.error("Get data from database fail");
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error"));
        }
        NguoiGiamHo nguoiGiamHo = registryForm.getNguoiGiamHo().convertToEntity(registryForm.getNguoiGiamHo());
        nguoiGiamHo.setGiamHoID(UUID.randomUUID().toString());
        nguoiGiamHo.setSoKham(soKham);
        try {
            nguoiGiamHoRepo.save(nguoiGiamHo);
        }catch (Exception e){
            log.error(String.valueOf(e));
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error"));
        }
        return ResponseEntity.ok().body(CommonUtil.returnMessage("message", "Registry successfully"));
    }
}
