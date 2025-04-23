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
}
