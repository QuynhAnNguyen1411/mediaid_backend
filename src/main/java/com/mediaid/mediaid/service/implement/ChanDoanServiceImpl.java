package com.mediaid.mediaid.service.implement;

import com.mediaid.mediaid.DTO.chanDoan.DanhSachBoPhan;
import com.mediaid.mediaid.DTO.chanDoan.DanhSachBoPhanVaTrieuChung;
import com.mediaid.mediaid.DTO.chanDoan.DanhSachTrieuChung;
import com.mediaid.mediaid.model.BoPhanCoThe;
import com.mediaid.mediaid.model.PhanVungCoThe;
import com.mediaid.mediaid.model.TrieuChung;
import com.mediaid.mediaid.repository.*;
import com.mediaid.mediaid.service.abstracts.ChanDoanService;
import com.mediaid.mediaid.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<PhanVungCoThe> phanVungCoTheList = phanVungCoTheRepo.findByStatus(true);
        Map<String, DanhSachBoPhanVaTrieuChung> danhSachBoPhanHashMap = new HashMap<>();

        DanhSachBoPhanVaTrieuChung danhSachBoPhanVaTrieuChung;
        List<BoPhanCoThe> boPhanCoThes;
        List<TrieuChung> trieuChungs;
        DanhSachBoPhan danhSachBoPhan;
        List<DanhSachBoPhan> danhSachBoPhans;
        DanhSachTrieuChung danhSachTrieuChung;
        List<DanhSachTrieuChung> danhSachTrieuChungs;

        for(PhanVungCoThe phanVungCoThe: phanVungCoTheList){
            danhSachBoPhanVaTrieuChung = new DanhSachBoPhanVaTrieuChung(phanVungCoThe.getPhanVungID(),phanVungCoThe.getTen());
            boPhanCoThes = boPhanCoTheRepo.findByStatusAndGioiTinhIDAndPhanVungID(true, gioiTinhID, phanVungCoThe.getPhanVungID());

            if (!CommonUtil.isNullOrEmpty(boPhanCoThes)){
                danhSachBoPhans = new ArrayList<>();
                for (BoPhanCoThe boPhanCoThe: boPhanCoThes){
                    danhSachBoPhan = new DanhSachBoPhan(boPhanCoThe.getBoPhanID(), boPhanCoThe.getTen());
                    trieuChungs = trieuChungRepo.findByStatusAndBoPhanID(true, boPhanCoThe.getBoPhanID());
                    if(!CommonUtil.isNullOrEmpty(trieuChungs)){
                        danhSachTrieuChungs = new ArrayList<>();
                        for(TrieuChung trieuChung: trieuChungs){
                            danhSachTrieuChung = new DanhSachTrieuChung(trieuChung.getTrieuChungID(), trieuChung.getTrieuChung());
                            danhSachTrieuChungs.add(danhSachTrieuChung);
                        }
                        danhSachBoPhan.setDanhSachTrieuChungs(danhSachTrieuChungs);
                    }
                    danhSachBoPhans.add(danhSachBoPhan);
                }
                danhSachBoPhanVaTrieuChung.setDanhSachBoPhanList(danhSachBoPhans);
            }
            danhSachBoPhanHashMap.put(phanVungCoThe.getPhanVungID(), danhSachBoPhanVaTrieuChung);
        }
        return ResponseEntity.ok(danhSachBoPhanHashMap);
    }
}
