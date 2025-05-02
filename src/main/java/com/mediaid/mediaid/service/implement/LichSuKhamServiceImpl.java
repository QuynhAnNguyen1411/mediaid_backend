package com.mediaid.mediaid.service.implement;

import com.mediaid.mediaid.DTO.lichSuKham.LichSuKhamChiTietDTO;
import com.mediaid.mediaid.DTO.lichSuKham.LichSuKhamDTO;
import com.mediaid.mediaid.repository.LichSuKhamChiTietRepo;
import com.mediaid.mediaid.repository.LichSuKhamRepo;
import com.mediaid.mediaid.service.abstracts.LichSuKhamService;
import com.mediaid.mediaid.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LichSuKhamServiceImpl implements LichSuKhamService {
    @Autowired
    LichSuKhamRepo lichSuKhamRepo;
    @Autowired
    LichSuKhamChiTietRepo lichSuKhamChiTietRepo;

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
    public ResponseEntity<?> layDanhSachLichSuKhamChiTiet(String lichSuKhamID) {
        if(CommonUtil.isNullOrEmpty(lichSuKhamID)){
            return ResponseEntity.badRequest().body(CommonUtil.returnMessage("message", "Invalid sokhamID"));
        }
        List<LichSuKhamChiTietDTO> lichSuKhamChiTietDTOS;
        try {
            lichSuKhamChiTietDTOS = lichSuKhamChiTietRepo.findByLichSuKhamID(lichSuKhamID);
            return ResponseEntity.ok().body(lichSuKhamChiTietDTOS);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(CommonUtil.returnMessage("message", "Internal server error"));
        }
    }
}
