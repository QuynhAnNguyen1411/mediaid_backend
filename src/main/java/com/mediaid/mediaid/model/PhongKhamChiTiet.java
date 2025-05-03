package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhongKhamChiTiet {

    @Id
    private String phongKhamChiTietID;
    @Column(unique = true, nullable = false)
    private String maPhongKham;
    @Range(min = 10, max = 100)
    private int gioiHanLaySo;
    private boolean status;

    public PhongKhamChiTiet(String phongKhamChiTietID, String maPhongKham, int gioiHanLaySo, boolean status, PhongKham phongKham, CoSoBenhVien coSoBenhVien) {
        this.phongKhamChiTietID = phongKhamChiTietID;
        this.maPhongKham = maPhongKham;
        this.gioiHanLaySo = gioiHanLaySo;
        this.status = status;
        this.phongKham = phongKham;
        this.coSoBenhVien = coSoBenhVien;
    }

    @OneToMany(mappedBy = "phongKhamChiTiet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SoKhamTheoPhong> soKhamTheoPhongs;

    @OneToMany(mappedBy = "phongKhamChiTiet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LichSuKhamChiTiet> lichSuKhamChiTiets;

    @ManyToOne
    @JoinColumn(name = "PhongKhamID",nullable = false)
    private PhongKham phongKham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coSoBenhVienID")
    private CoSoBenhVien coSoBenhVien;

}