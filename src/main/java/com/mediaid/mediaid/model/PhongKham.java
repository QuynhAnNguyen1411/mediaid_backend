package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhongKham {

    @Id
    private String phongKhamID;
    @Column(nullable = false, unique = true)
    private String phongKham;
    private boolean isPhongKhamChanDoan;
    private boolean status;

    public PhongKham(String phongKhamID, String phongKham, boolean isPhongKhamChanDoan, boolean status, DichVuKham dichVuKham) {
        this.phongKhamID = phongKhamID;
        this.phongKham = phongKham;
        this.isPhongKhamChanDoan = isPhongKhamChanDoan;
        this.status = status;
        this.dichVuKham = dichVuKham;
    }

    @OneToMany(mappedBy = "phongKham", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PhongKhamChiTiet> phongKhamChiTiets;
    @OneToMany(mappedBy = "phongKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChanDoanBangPhanVung> chanDoanBangPhanVungs;
    @OneToMany(mappedBy = "phongKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChanDoanBangBoPhan> chanDoanBangBoPhans;
    @OneToMany(mappedBy = "phongKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChanDoanBangBoPhanVaTrieuChung> chanDoanBangBoPhanVaTrieuChungs;
    @ManyToOne
    @JoinColumn(name = "dichVuKhamID", nullable = false)
    private DichVuKham dichVuKham;
}