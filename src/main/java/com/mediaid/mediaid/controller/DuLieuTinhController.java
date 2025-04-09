package com.mediaid.mediaid.controller;

import com.mediaid.mediaid.service.abstracts.StaticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/static")
public class DuLieuTinhController {
    @Autowired
    StaticService staticService;
    @GetMapping("/staticDataForRegistry")
    public ResponseEntity<?> layDuLieuTinhChoFormDangKy() {
        return staticService.getStaticRegistryData();
    }
    @GetMapping("/staticDataForTieuSuYTe")
    public ResponseEntity<?> getDuLieuTinhChoTieuSuYTe() {
        return staticService.getStaticDataForTieuSuYTe();
    }

    @GetMapping("/staticDataForTieuSuThuoc")
    public ResponseEntity<?> staticDataForTieuSuThuoc() {
        return staticService.getStaticDataForTieuSuThuoc();
    }
    @GetMapping("/staticDataForTieuSuLoiSong")
    public ResponseEntity<?> staticDataForTieuSuLoiSong() {
        return staticService.getStaticDataForLoiSong();
    }
}
