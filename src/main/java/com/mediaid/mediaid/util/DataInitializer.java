package com.mediaid.mediaid.util;

import com.mediaid.mediaid.model.DanToc;
import com.mediaid.mediaid.model.GioiTinh;
import com.mediaid.mediaid.repository.DanTocRepo;
import com.mediaid.mediaid.repository.GenderRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {
    private final DanTocRepo danTocRepository;
    private final GenderRepo genderRepo;

    public DataInitializer(DanTocRepo danTocRepository, GenderRepo genderRepo) {
        this.danTocRepository = danTocRepository;
        this.genderRepo = genderRepo;
    }

    @Override
    public void run(String... args) {
        // Check if data already exists
        if (danTocRepository.count() == 0) {
            List<DanToc> danTocList = List.of(
                new DanToc("Kinh"),
                new DanToc("Tày"),
                new DanToc("Thái"),
                new DanToc("Mường"),
                new DanToc("H'Mông")
            );
            danTocRepository.saveAll(danTocList);
            log.info("Inserted default DanToc data into the database.");
        }
        if (genderRepo.count() == 0) {
            List<GioiTinh> genderList = List.of(
                    new GioiTinh("Nam"),
                    new GioiTinh("Nữ"),
                    new GioiTinh("Khác")
            );
            genderRepo.saveAll(genderList);
            log.info("Inserted default GioiTinh data into the database.");
        }
    }
}
