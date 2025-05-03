package com.mediaid.mediaid.service.implement;

import com.mediaid.mediaid.DTO.lichSuKham.*;
import com.mediaid.mediaid.model.LichSuKham;
import com.mediaid.mediaid.repository.LichSuKhamChiTietRepo;
import com.mediaid.mediaid.repository.LichSuKhamRepo;
import com.mediaid.mediaid.repository.LichSuSuDungThuocRepo;
import com.mediaid.mediaid.service.abstracts.LichSuKhamService;
import com.mediaid.mediaid.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LichSuKhamServiceImpl implements LichSuKhamService {
    @Autowired
    LichSuKhamRepo lichSuKhamRepo;
    @Autowired
    LichSuKhamChiTietRepo lichSuKhamChiTietRepo;
    @Autowired
    LichSuSuDungThuocRepo lichSuSuDungThuocRepo;

    @Override
    public ResponseEntity<?> layDanhSachLichSuKham(String soKhamID) {
        if(CommonUtil.isNullOrEmpty(soKhamID)){
            return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid sokhamID"));
        }
        List<LichSuKhamDTO> lichSuKhamDTOS;
        try {
            lichSuKhamDTOS = lichSuKhamRepo.findBySoKhamID(soKhamID);
            return ResponseEntity.ok().body(lichSuKhamDTOS);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal server error"));
        }
    }

    @Override
    public ResponseEntity<?> layLichSuKham(String lichSuKhamID) {
        if(CommonUtil.isNullOrEmpty(lichSuKhamID)){
            return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid lichSuKhamID"));
        }
        LichSuKhamDTO lichSuKhamDTO = new LichSuKhamDTO();
        try {
            Optional<LichSuKham> query = lichSuKhamRepo.findById(lichSuKhamID);
            if (query.isEmpty()){
                return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid lichSuKhamID"));
            }
            LichSuKham lichSuKham = query.get();
            List<LichSuKhamChiTietDTO> lichSuKhamChiTietDTOS = lichSuKhamChiTietRepo.findByLichSuKhamID(lichSuKhamID);
            List<LichSuSuDungThuocDTO> lichSuSuDungThuocDTOS = lichSuSuDungThuocRepo.findByLichSuKhamID(lichSuKhamID);
            lichSuKhamDTO.setLichSuKhamChiTietDTOS(lichSuKhamChiTietDTOS);
            lichSuKhamDTO.setLichSuSuDungThuocDTOList(lichSuSuDungThuocDTOS);
            lichSuKhamDTO.setNgay_kham(lichSuKham.getNgayKham());
            lichSuKhamDTO.setLich_su_khamid(lichSuKhamID);
            lichSuKhamDTO.setCoSo(lichSuKham.getCoSoBenhVien().getTen());
            lichSuKhamDTO.setKet_luan(lichSuKham.getKetLuan());
            lichSuKhamDTO.setTrang_thai(lichSuKham.getTrangThaiKham().getTrangThai());

            return ResponseEntity.ok().body(lichSuKhamDTO);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal server error"));
        }
    }

    @Override
    public ResponseEntity<?> layLichSuKhamChiTiet(String lichSuKhamChiTietID) {
        if(CommonUtil.isNullOrEmpty(lichSuKhamChiTietID)){
            return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid lichSuKhamChiTietID"));
        }
        LichSuKhamChiTietDTO lichSuKhamChiTietDTO;
        try {
            lichSuKhamChiTietDTO = lichSuKhamChiTietRepo.findByLichSuKhamChiTietID(lichSuKhamChiTietID);
            return ResponseEntity.ok().body(lichSuKhamChiTietDTO);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal server error"));
        }
    }
}
