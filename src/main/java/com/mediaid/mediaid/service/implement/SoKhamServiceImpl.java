package com.mediaid.mediaid.service.implement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuBenhTatDTO;
import com.mediaid.mediaid.model.MucDo;
import com.mediaid.mediaid.model.PhuongPhapDieuTri;
import com.mediaid.mediaid.model.SoKham;
import com.mediaid.mediaid.model.TieuSuBenhTat;
import com.mediaid.mediaid.repository.MucDoRepo;
import com.mediaid.mediaid.repository.PhuongPhapDieuTriRepo;
import com.mediaid.mediaid.repository.SoKhamRepo;
import com.mediaid.mediaid.repository.TieuSuBenhTatRepo;
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
            soKham = soKhamRepo.findBySoKhamId(tieuSuBenhTatDTO.getSoKhamID());
            mucDo = mucDoRepo.findByMucDoId(tieuSuBenhTatDTO.getMucDoID());
            phuongPhapDieuTri = phuongPhapDieuTriRepo.findByPhuongPhapDieuTriId(tieuSuBenhTatDTO.getPhuongPhapDieuTriID());
            if(CommonUtil.isNullOrEmpty(soKham) || CommonUtil.isNullOrEmpty(mucDo) || CommonUtil.isNullOrEmpty(phuongPhapDieuTri)){
                log.warn("Invalid id data in request "+new ObjectMapper().writeValueAsString(tieuSuBenhTatDTO));
                return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid data"));
            }
            if (CommonUtil.isNullOrEmpty(tieuSuBenhTatDTO.getTieuSuBenhTatID())){
                tieuSuBenhTat = new TieuSuBenhTat();
                tieuSuBenhTat.setSoKham(soKham);
                tieuSuBenhTat.setTieuSuBenhTatID(UUID.randomUUID().toString());
            } else {
                tieuSuBenhTat = tieuSuBenhTatRepo.findByTieuSuBenhTatId(tieuSuBenhTatDTO.getTieuSuBenhTatID());
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
}
