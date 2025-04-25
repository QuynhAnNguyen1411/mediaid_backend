package com.mediaid.mediaid.controller;


import com.mediaid.mediaid.service.abstracts.ChanDoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChanDoanController {
    @Autowired
    ChanDoanService chanDoanService;

    @GetMapping("/layDanhSachBoPhanVaTrieuChung")
    public ResponseEntity<?> layDanhSachBoPhanVaTrieuChung(@RequestParam int gioiTinhID) {
        return chanDoanService.layDanhSachBoPhanVaTrieuChung(gioiTinhID);
    }
}
