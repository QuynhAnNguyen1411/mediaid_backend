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
public class CoSoBenhVien {
    @Id
    private int CoSoID;

    private String ten;
    private String diaChi;

    public CoSoBenhVien(int coSoID, String ten, String diaChi) {
        CoSoID = coSoID;
        this.ten = ten;
        this.diaChi = diaChi;
    }

    @OneToMany(mappedBy = "coSoBenhVien", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BacSi> bacSis;
    @OneToMany(mappedBy = "coSoBenhVien", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PhongKhamChiTiet> phongKhamChiTiets;
    @OneToMany(mappedBy = "coSoBenhVien", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LichSuKham> lichSuKhams;
}

