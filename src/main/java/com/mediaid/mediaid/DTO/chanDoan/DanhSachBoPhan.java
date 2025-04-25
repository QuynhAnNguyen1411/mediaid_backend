package com.mediaid.mediaid.DTO.chanDoan;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DanhSachBoPhan {
    private String boPhanID;

    private String ten;
    private List<DanhSachTrieuChung> danhSachTrieuChungs;

    public DanhSachBoPhan(String boPhanID, String ten) {
        this.boPhanID = boPhanID;
        this.ten = ten;
    }
}
