package com.mediaid.mediaid.controller;

import com.mediaid.mediaid.DTO.form.formTieuSuYTe.*;
import com.mediaid.mediaid.DTO.staticData.GetMappingData.SoKhamDTO;
import com.mediaid.mediaid.service.abstracts.SoKhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class SoKhamController {
    @Autowired
    SoKhamService soKhamService;
    @PostMapping("/capNhatTieuSuBenhTat")
    public ResponseEntity<?> capNhatTieuSuBenhTat(@RequestBody @Valid TieuSuBenhTatDTO tieuSuBenhTatDTO, BindingResult bindingResult) {
        return soKhamService.capNhatTieuSuBenhTat(tieuSuBenhTatDTO, bindingResult);
    }
    @PostMapping("/capNhatTieuSuBenhDiTruyen")
    public ResponseEntity<?> capNhatTieuSuBenhDiTruyen(@RequestBody @Valid TieuSuBenhDiTruyenDTO tieuSuBenhDiTruyenDTO, BindingResult bindingResult) {
        return soKhamService.capNhatTieuSuBenhDiTruyen(tieuSuBenhDiTruyenDTO, bindingResult);
    }
    @PostMapping("/capNhatTieuSuDiUng")
    public ResponseEntity<?> capNhatTieuSuDiUng(@RequestBody @Valid TieuSuDiUngDTO tieuSuDiUngDTO, BindingResult bindingResult) {
        return soKhamService.capNhatTieuSuDiUng(tieuSuDiUngDTO, bindingResult);
    }
    @PostMapping("/capNhatTieuSuPhauThuat")
    public ResponseEntity<?> capNhatTieuSuPhauThuat(@RequestBody @Valid TieuSuPhauThuatDTO tieuSuPhauThuatDTO, BindingResult bindingResult) {
        return soKhamService.capNhatTieuSuPhauThuat(tieuSuPhauThuatDTO, bindingResult);
    }
    @PostMapping("/capNhatTieuSuLoiSong")
    public ResponseEntity<?> capNhatTieuSuLoiSong(@RequestBody @Valid TieuSuLoiSongDTO tieuSuPhauThuatDTO, BindingResult bindingResult) {
        return soKhamService.capNhatTieuSuLoiSong(tieuSuPhauThuatDTO, bindingResult);
    }
    @PostMapping("/capNhatTieuSuThuoc")
    public ResponseEntity<?> capNhatTieuSuThuoc(@RequestBody @Valid TieuSuThuocDTO tieuSuThuocDTO, BindingResult bindingResult) {
        return soKhamService.capNhatTieuSuThuoc(tieuSuThuocDTO, bindingResult);
    }
    @PostMapping("/capNhatThongTinCaNhan")
    public ResponseEntity<?> capNhatThongTinCaNhan(@RequestBody @Valid SoKhamDTO soKhamDTO, BindingResult bindingResult) {
        return soKhamService.capNhatThongTinSoKham(soKhamDTO, bindingResult);
    }
    @GetMapping("/layThongTinSoKham")
    public ResponseEntity<?> layThongTinSoKham(@RequestParam String accountID) {
        return soKhamService.getSoKham(accountID);
    }
    @GetMapping("/layTieuSuLoiSong")
    public ResponseEntity<?> layTieuSuLoiSong(@RequestParam String accountID) {
        return soKhamService.getTieuSuLoiSong(accountID);
    }
    @GetMapping("/layDanhSachTieuSuPreview")
    public ResponseEntity<?> layDanhSachTieuSuPreview(@RequestParam String accountID, @RequestParam String type) {
        return soKhamService.getDanhSachTieuSuTheoLoai(accountID, type);
    }
    @GetMapping("/layCoSoKhamBenh")
    public ResponseEntity<?> layDanhSachTieuSuPreview() {
        return soKhamService.getAllCoSoBenhVien();
    }
    @DeleteMapping("/xoaTieuSuYTe")
    public ResponseEntity<?> xoaTieuSuYTe(@RequestParam String tieuSuYTeID, @RequestParam String type) {
        return soKhamService.deleteTieuSuTheoLoai(tieuSuYTeID, type);
    }
}
