package com.mediaid.mediaid.service.abstracts;

import org.springframework.http.ResponseEntity;

public interface ChanDoanService {
    ResponseEntity<?> layDanhSachBoPhanVaTrieuChung(int gioiTinhID);
}
