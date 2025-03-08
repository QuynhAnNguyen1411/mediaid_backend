package com.mediaid.mediaid.service.implement;

import com.mediaid.mediaid.DTO.Gender;
import com.mediaid.mediaid.DTO.Nation;
import com.mediaid.mediaid.DTO.StaticRegistryData;
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
public class StaticServiceImplement implements StaticService {
    @Autowired
    GenderRepo genderRepo;
    @Autowired
    DanTocRepo danTocRepo;

    @Override
    public ResponseEntity<?> getStaticRegistryData() {
        try {
            List<GioiTinh> gioiTinhs = genderRepo.findAll();
            List<DanToc> danTocs = danTocRepo.findAll();

            List<Gender> genders = new ArrayList<>();
            List<Nation> nations = new ArrayList<>();

            gioiTinhs.forEach( gioiTinh -> {
                Gender gender = new Gender(gioiTinh.getGioiTinhID(), gioiTinh.getTitle());
                genders.add(gender);
            });
            danTocs.forEach( danToc -> {
                Nation nation = new Nation(danToc.getDanTocID(), danToc.getTitle());
                nations.add(nation);
            });
            return ResponseEntity.ok(new StaticRegistryData(genders, nations));
        }catch (Exception e){
            log.error(String.valueOf(e));
            return ResponseEntity.internalServerError().body("Fail to get static registry data");
        }
    }
}
