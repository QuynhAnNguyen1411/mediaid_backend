package com.mediaid.mediaid.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChanDoanController {

    @GetMapping("/layDanhSachBoPhanVaTrieuChung")
    public ResponseEntity<?> layDanhSachBoPhanVaTrieuChung(@RequestParam String gioiTinhID) {
        return null;
    }
}
