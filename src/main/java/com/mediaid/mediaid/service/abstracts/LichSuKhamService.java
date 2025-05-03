package com.mediaid.mediaid.service.abstracts;

import org.springframework.http.ResponseEntity;

public interface LichSuKhamService {
    ResponseEntity<?> layDanhSachLichSuKham(String soKhamID);
    ResponseEntity<?> layDanhSachLichSuKhamChiTiet(String lichSuKhamID);
    ResponseEntity<?> layLichSuKhamChiTiet(String lichSuKhamChiTietID);

}
