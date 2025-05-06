package com.mediaid.mediaid.service.abstracts;

import com.mediaid.mediaid.DTO.chanDoan.ChanDoanDTO;
import org.springframework.http.ResponseEntity;

public interface ChanDoanService {
    ResponseEntity<?> layDanhSachBoPhanVaTrieuChung(String accountID);
    ResponseEntity<?> chanDoan(ChanDoanDTO chanDoanDTO);
}
