package com.mediaid.mediaid.DTO.chanDoan;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DanhSachBoPhanVaTrieuChung {
    private String PhanVungID;
    private String Ten;
    private List<DanhSachBoPhan> danhSachBoPhanList;

    public DanhSachBoPhanVaTrieuChung(String phanVungID, String ten) {
        PhanVungID = phanVungID;
        Ten = ten;
    }
}
