package com.mediaid.mediaid.controller;


import com.mediaid.mediaid.service.abstracts.LichSuKhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LichSuKhamController {
    @Autowired
    LichSuKhamService lichSuKhamService;

    @GetMapping("/layDanhSachLichSuKham")
    public ResponseEntity<?> layDanhSachLichSuKham(@RequestParam String soKhamID) {
        return lichSuKhamService.layDanhSachLichSuKham(soKhamID);
    }
    @GetMapping("/layDanhSachLichSuKhamChiTiet")
    public ResponseEntity<?> layDanhSachLichSuKhamChiTiet(@RequestParam String lichSuKhamID) {
        return lichSuKhamService.layDanhSachLichSuKhamChiTiet(lichSuKhamID);
    }
    @GetMapping("/layLichSuKhamChiTiet")
    public ResponseEntity<?> layLichSuKhamChiTiet(@RequestParam String lichSuKhamChiTietID) {
        return lichSuKhamService.layLichSuKhamChiTiet(lichSuKhamChiTietID);
    }
}
