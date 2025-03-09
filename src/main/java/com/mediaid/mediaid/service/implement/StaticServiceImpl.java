package com.mediaid.mediaid.service.implement;

import com.mediaid.mediaid.DTO.staticData.GioiTinhDTO;
import com.mediaid.mediaid.DTO.staticData.DanTocDTO;
import com.mediaid.mediaid.DTO.staticData.StaticRegistryData;
import com.mediaid.mediaid.model.DanToc;
import com.mediaid.mediaid.model.GioiTinh;
import com.mediaid.mediaid.repository.DanTocRepo;
import com.mediaid.mediaid.repository.GenderRepo;
import com.mediaid.mediaid.service.abtract.StaticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class StaticServiceImpl implements StaticService {
    @Autowired
    GenderRepo genderRepo;
    @Autowired
    DanTocRepo danTocRepo;

    @Override
    public ResponseEntity<?> getStaticRegistryData() {
        try {
            List<GioiTinh> gioiTinhs = genderRepo.findAll();
            List<DanToc> danTocs = danTocRepo.findAll();

            List<GioiTinhDTO> gioiTinhDTOS = new ArrayList<>();
            List<DanTocDTO> danTocDTOS = new ArrayList<>();

            gioiTinhs.forEach( gioiTinh -> {
                GioiTinhDTO gioiTinhDTO = new GioiTinhDTO(gioiTinh.getGioiTinhID(), gioiTinh.getTitle());
                gioiTinhDTOS.add(gioiTinhDTO);
            });
            danTocs.forEach( danToc -> {
                DanTocDTO danTocDTO = new DanTocDTO(danToc.getDanTocID(), danToc.getTitle());
                danTocDTOS.add(danTocDTO);
            });
            return ResponseEntity.ok(new StaticRegistryData(gioiTinhDTOS, danTocDTOS));
        }catch (Exception e){
            log.error(String.valueOf(e));
            return ResponseEntity.internalServerError().body("Fail to get static registry data");
        }
    }

    @Override
    public ResponseEntity<?> getStaticSoKhamData() {
        return null;
    }
}
