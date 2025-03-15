package com.mediaid.mediaid.service.implement;

import com.mediaid.mediaid.DTO.staticData.FormDangKy.GioiTinhDTO;
import com.mediaid.mediaid.DTO.staticData.FormDangKy.DanTocDTO;
import com.mediaid.mediaid.DTO.staticData.FormDangKy.DuLieuTinhChoFormDangKy;
import com.mediaid.mediaid.model.*;
import com.mediaid.mediaid.repository.*;
import com.mediaid.mediaid.service.abstracts.StaticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class StaticServiceImpl implements StaticService {
    @Autowired
    GenderRepo genderRepo;
    @Autowired
    DanTocRepo danTocRepo;
    @Autowired
    LyDoPhauThuatRepo lyDoPhauThuatRepo;
    @Autowired
    MucDoRepo mucDoRepo;
    @Autowired
    PhuongPhapDieuTriRepo phuongPhapDieuTriRepo;
    @Autowired
    TrangThaiDieuTriRepo trangThaiDieuTriRepo;

    @Override
    public ResponseEntity<?> getStaticRegistryData() {
        try {
            List<GioiTinh> gioiTinhs = genderRepo.findAll();
            List<DanToc> danTocs = danTocRepo.findAll();

            List<GioiTinhDTO> gioiTinhDTOS = GioiTinhDTO.gioiTinhDTOList(gioiTinhs);
            List<DanTocDTO> danTocDTOS = DanTocDTO.danTocDTOList(danTocs);

            return ResponseEntity.ok(new DuLieuTinhChoFormDangKy(gioiTinhDTOS, danTocDTOS));
        }catch (Exception e){
            log.error(String.valueOf(e));
            return ResponseEntity.internalServerError().body("Fail to get static registry data");
        }
    }

    @Override
    public ResponseEntity<?> getStaticDataForTieuSuYTe() {
        List<LyDoPhauThuat> lyDoPhauThuats = lyDoPhauThuatRepo.findByStatus(true);
        List<PhuongPhapDieuTri> phuongPhapDieuTris = phuongPhapDieuTriRepo.findByStatus(true);
        List<MucDo> mucDos = mucDoRepo.findByStatus(true);
        List<TrangThaiDieuTri> trangThaiDieuTris = trangThaiDieuTriRepo.findByStatus(true);



        return null;
    }

}
