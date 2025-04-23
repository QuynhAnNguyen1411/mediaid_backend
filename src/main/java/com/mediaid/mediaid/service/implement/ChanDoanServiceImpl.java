package com.mediaid.mediaid.service.implement;

import com.mediaid.mediaid.repository.*;
import com.mediaid.mediaid.service.abstracts.ChanDoanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChanDoanServiceImpl implements ChanDoanService {
    @Autowired
    PhanVungCoTheRepo phanVungCoTheRepo;
    @Autowired
    BoPhanCoTheRepo boPhanCoTheRepo;
    @Autowired
    TrieuChungRepo trieuChungRepo;

    @Override
    public ResponseEntity<?> layDanhSachBoPhanVaTrieuChung(int gioiTinhID) {
        return null;
    }
}
