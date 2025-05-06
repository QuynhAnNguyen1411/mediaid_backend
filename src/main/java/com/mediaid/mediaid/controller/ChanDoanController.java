package com.mediaid.mediaid.controller;


import com.mediaid.mediaid.DTO.chanDoan.ChanDoanDTO;
import com.mediaid.mediaid.service.abstracts.ChanDoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChanDoanController {
    @Autowired
    ChanDoanService chanDoanService;

    @GetMapping("/layDanhSachBoPhanVaTrieuChung")
    public ResponseEntity<?> layDanhSachBoPhanVaTrieuChung(@RequestParam String accountID) {
        return chanDoanService.layDanhSachBoPhanVaTrieuChung(accountID);
    }
    @PostMapping("/LaySo")
    public ResponseEntity<?> layDanhSachBoPhanVaTrieuChung(@RequestBody ChanDoanDTO chanDoanDTO) {
        return chanDoanService.chanDoan(chanDoanDTO);
    }
}
