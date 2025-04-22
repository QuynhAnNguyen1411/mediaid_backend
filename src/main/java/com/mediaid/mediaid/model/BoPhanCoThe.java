package com.mediaid.mediaid.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoPhanCoThe {
    @Id
    private String boPhanID;

    private String ten;
    private boolean status;

    public BoPhanCoThe(String boPhanID, String ten, boolean status, PhanVungCoThe phanVungCoThe, GioiTinh gioiTinh) {
        this.boPhanID = boPhanID;
        this.ten = ten;
        this.status = status;
        this.phanVungCoThe = phanVungCoThe;
        this.gioiTinh = gioiTinh;
    }

    @OneToMany(mappedBy = "boPhanCoThe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TrieuChungCuaBoPhan> trieuChungCuaBoPhans;

    @OneToMany(mappedBy = "boPhanCoThe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChanDoan> chanDoans;

    @ManyToOne
    @JoinColumn(name = "phanVungCoTheID")
    private PhanVungCoThe phanVungCoThe;
    @ManyToOne
    @JoinColumn(name = "GioiTinhID")
    private GioiTinh gioiTinh;
}

