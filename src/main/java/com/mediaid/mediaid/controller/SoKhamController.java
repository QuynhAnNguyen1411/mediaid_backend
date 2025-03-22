package com.mediaid.mediaid.controller;

import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuBenhDiTruyenDTO;
import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuBenhTatDTO;
import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuDiUngDTO;
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
    @GetMapping("/layThongTinSoKham")
    public ResponseEntity<?> layThongTinSoKham(@RequestParam String accountID) {
        return soKhamService.getSoKham(accountID);
    }
}
