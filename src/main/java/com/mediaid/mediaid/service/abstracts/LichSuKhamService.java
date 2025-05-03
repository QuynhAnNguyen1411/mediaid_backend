package com.mediaid.mediaid.service.abstracts;

import org.springframework.http.ResponseEntity;

public interface LichSuKhamService {
    ResponseEntity<?> layDanhSachLichSuKham(String soKhamID);
    ResponseEntity<?> layLichSuKham(String lichSuKhamID);
    ResponseEntity<?> layLichSuKhamChiTiet(String lichSuKhamChiTietID);

}
