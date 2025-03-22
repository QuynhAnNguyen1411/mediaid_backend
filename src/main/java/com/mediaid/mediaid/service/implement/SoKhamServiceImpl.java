package com.mediaid.mediaid.service.implement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuBenhDiTruyenDTO;
import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuBenhTatDTO;
import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuDiUngDTO;
import com.mediaid.mediaid.DTO.staticData.GetMappingData.SoKhamDTO;
import com.mediaid.mediaid.model.*;
import com.mediaid.mediaid.repository.*;
import com.mediaid.mediaid.service.abstracts.SoKhamService;
import com.mediaid.mediaid.util.CommonUtil;
import com.mediaid.mediaid.util.ValidationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.UUID;

@Service
@Slf4j
public class SoKhamServiceImpl implements SoKhamService {
    @Autowired
    MucDoRepo mucDoRepo;
    @Autowired
    PhuongPhapDieuTriRepo phuongPhapDieuTriRepo;
    @Autowired
    SoKhamRepo soKhamRepo;
    @Autowired
    TieuSuBenhTatRepo tieuSuBenhTatRepo;
    @Autowired
    TieuSuBenhDiTruyenRepo tieuSuBenhDiTruyenRepo;
    @Autowired
    TieuSuDiUngRepo tieuSuDiUngRepo;
    @Override
    public ResponseEntity<?> capNhatTieuSuBenhTat(TieuSuBenhTatDTO tieuSuBenhTatDTO, BindingResult bindingResult) {
        HashMap<String,String> errors = ValidationUtil.validationCheckBindingResult(bindingResult);
        if (!CommonUtil.isNullOrEmpty(errors)){
            log.warn(errors.toString());
            return ResponseEntity.badRequest().body(errors);
        }
        MucDo mucDo;
        PhuongPhapDieuTri phuongPhapDieuTri;
        SoKham soKham;
        TieuSuBenhTat tieuSuBenhTat;
        try {
            soKham = soKhamRepo.findBySoKhamID(tieuSuBenhTatDTO.getSoKhamID());
            mucDo = mucDoRepo.findByMucDoID(tieuSuBenhTatDTO.getMucDoID());
            phuongPhapDieuTri = phuongPhapDieuTriRepo.findByPhuongPhapDieuTriID(tieuSuBenhTatDTO.getPhuongPhapDieuTriID());
            if(CommonUtil.isNullOrEmpty(soKham) || CommonUtil.isNullOrEmpty(mucDo) || CommonUtil.isNullOrEmpty(phuongPhapDieuTri)){
                log.warn("Invalid id data in request "+new ObjectMapper().writeValueAsString(tieuSuBenhTatDTO));
                return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid data"));
            }
            if (CommonUtil.isNullOrEmpty(tieuSuBenhTatDTO.getTieuSuBenhTatID())){
                tieuSuBenhTat = new TieuSuBenhTat();
                tieuSuBenhTat.setSoKham(soKham);
                tieuSuBenhTat.setTieuSuBenhTatID(UUID.randomUUID().toString());
            } else {
                tieuSuBenhTat = tieuSuBenhTatRepo.findByTieuSuBenhTatID(tieuSuBenhTatDTO.getTieuSuBenhTatID());
                if (CommonUtil.isNullOrEmpty(tieuSuBenhTat)){
                    log.warn("Invalid id data in update request "+new ObjectMapper().writeValueAsString(tieuSuBenhTatDTO));
                    return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid tieuSuBenhTatID"));
                }
            }
        }catch (Exception e){
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
        tieuSuBenhTat.setMucDo(mucDo);
        tieuSuBenhTat.setPhuongPhapDieuTri(phuongPhapDieuTri);
        tieuSuBenhTat.setLoaiBenh(tieuSuBenhTatDTO.getLoaiBenh());
        tieuSuBenhTat.setBienChung(tieuSuBenhTatDTO.getBienChung());
        tieuSuBenhTat.setBenhVienDieuTri(tieuSuBenhTat.getBenhVienDieuTri());
        tieuSuBenhTat.setNamPhatHien(tieuSuBenhTatDTO.getNamPhatHien());
        tieuSuBenhTat.setGhiChu(tieuSuBenhTatDTO.getGhiChu());
        try {
            tieuSuBenhTatRepo.save(tieuSuBenhTat);
            return ResponseEntity.ok(CommonUtil.returnMessage("message", "Save/update tieuSuBenhTat successfully"));
        }catch (Exception e){
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
    }

    @Override
    public ResponseEntity<?> capNhatTieuSuBenhDiTruyen(TieuSuBenhDiTruyenDTO tieuSuBenhDiTruyenDTO, BindingResult bindingResult) {
        HashMap<String,String> errors = ValidationUtil.validationCheckBindingResult(bindingResult);
        if (!CommonUtil.isNullOrEmpty(errors)){
            log.warn(errors.toString());
            return ResponseEntity.badRequest().body(errors);
        }
        MucDo mucDo;
        SoKham soKham;
        TieuSuBenhDiTruyen tieuSuBenhDiTruyen;
        try {
            soKham = soKhamRepo.findBySoKhamID(tieuSuBenhDiTruyenDTO.getSoKhamID());
            mucDo = mucDoRepo.findByMucDoID(tieuSuBenhDiTruyenDTO.getMucDoID());
            if(CommonUtil.isNullOrEmpty(soKham) || CommonUtil.isNullOrEmpty(mucDo)){
                log.warn("Invalid id data in request "+new ObjectMapper().writeValueAsString(tieuSuBenhDiTruyenDTO));
                return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid data"));
            }
            if (CommonUtil.isNullOrEmpty(tieuSuBenhDiTruyenDTO.getTieuSuBenhDiTruyenID())){
                tieuSuBenhDiTruyen = new TieuSuBenhDiTruyen();
                tieuSuBenhDiTruyen.setSoKham(soKham);
                tieuSuBenhDiTruyen.setTieuSuBenhDiTruyenID(UUID.randomUUID().toString());
            } else {
                tieuSuBenhDiTruyen = tieuSuBenhDiTruyenRepo.findByTieuSuBenhDiTruyenID(tieuSuBenhDiTruyenDTO.getTieuSuBenhDiTruyenID());
                if (CommonUtil.isNullOrEmpty(tieuSuBenhDiTruyen)){
                    log.warn("Invalid id data in update request "+new ObjectMapper().writeValueAsString(tieuSuBenhDiTruyenDTO));
                    return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid tieuSuBenhDiTruyenID"));
                }
            }
        }catch (Exception e){
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
        tieuSuBenhDiTruyen.setMucDo(mucDo);
        tieuSuBenhDiTruyen.setLoaiBenh(tieuSuBenhDiTruyenDTO.getLoaiBenh());
        tieuSuBenhDiTruyen.setThanhVienGiaDinh(tieuSuBenhDiTruyenDTO.getThanhVienGiaDinh());
        tieuSuBenhDiTruyen.setMoiQuanHeThanhVien(tieuSuBenhDiTruyenDTO.getMoiQuanHeThanhVien());
        tieuSuBenhDiTruyen.setNamPhatHien(tieuSuBenhDiTruyenDTO.getNamPhatHien());
        tieuSuBenhDiTruyen.setGhiChu(tieuSuBenhDiTruyenDTO.getGhiChu());
        try {
            tieuSuBenhDiTruyenRepo.save(tieuSuBenhDiTruyen);
            return ResponseEntity.ok(CommonUtil.returnMessage("message", "Save/update tieuSuBenhDiTruyen successfully"));
        }catch (Exception e){
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
    }

    @Override
    public ResponseEntity<?> capNhatTieuSuDiUng(TieuSuDiUngDTO tieuSuDiUngDTO, BindingResult bindingResult) {
        HashMap<String,String> errors = ValidationUtil.validationCheckBindingResult(bindingResult);
        if (!CommonUtil.isNullOrEmpty(errors)){
            log.warn(errors.toString());
            return ResponseEntity.badRequest().body(errors);
        }
        MucDo mucDo;
        SoKham soKham;
        TieuSuDiUng tieuSuDiUng;
        try {
            soKham = soKhamRepo.findBySoKhamID(tieuSuDiUngDTO.getSoKhamID());
            mucDo = mucDoRepo.findByMucDoID(tieuSuDiUngDTO.getMucDoID());
            if(CommonUtil.isNullOrEmpty(soKham) || CommonUtil.isNullOrEmpty(mucDo)){
                log.warn("Invalid id data in request "+new ObjectMapper().writeValueAsString(tieuSuDiUngDTO));
                return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid data"));
            }
            if (CommonUtil.isNullOrEmpty(tieuSuDiUngDTO.getTieuSuDiUngID())){
                tieuSuDiUng = new TieuSuDiUng();
                tieuSuDiUng.setSoKham(soKham);
                tieuSuDiUng.setTieuSuDiUngID(UUID.randomUUID().toString());
            } else {
                tieuSuDiUng = tieuSuDiUngRepo.findByTieuSuDiUngID(tieuSuDiUngDTO.getTieuSuDiUngID());
                if (CommonUtil.isNullOrEmpty(tieuSuDiUng)){
                    log.warn("Invalid id data in update request "+new ObjectMapper().writeValueAsString(tieuSuDiUngDTO));
                    return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid tieuSuDiUngID"));
                }
            }
        }catch (Exception e){
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
        tieuSuDiUng.setMucDo(mucDo);
        tieuSuDiUng.setTacNhan(tieuSuDiUngDTO.getTacNhan());
        tieuSuDiUng.setTrieuChung(tieuSuDiUngDTO.getTrieuChung());
        tieuSuDiUng.setLanCuoiXayRa(tieuSuDiUngDTO.getLanCuoiXayRa());
        tieuSuDiUng.setGhiChu(tieuSuDiUngDTO.getGhiChu());
        try {
            tieuSuDiUngRepo.save(tieuSuDiUng);
            return ResponseEntity.ok(CommonUtil.returnMessage("message", "Save/update tieuSuDiUng successfully"));
        }catch (Exception e){
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
    }

    @Override
    public ResponseEntity<?> getSoKham(String accountID) {
        if ( CommonUtil.isNullOrEmpty(accountID)){
            log.warn("Invalid accountID");
            return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Internal accountID"));
        }
        SoKhamDTO soKhamDTO;
        try {
            soKhamDTO = soKhamRepo.findByAccountID(accountID);
            if (CommonUtil.isNullOrEmpty(soKhamDTO)){
                log.warn("Invalid accountID");
                return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Internal accountID"));
            }
            return ResponseEntity.ok(soKhamDTO);
        }catch (Exception e){
            log.error("Exception", e);
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal error appear"));
        }
    }
}
