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
public class SoKham {
    @Id
    private String soKhamID;

    @ManyToOne
    @JoinColumn(name = "accountID")
    private Account account;

    private String bhyt;

    @OneToOne(mappedBy = "soKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private NguoiGiamHo nguoiGiamHos;
    @OneToMany(mappedBy = "soKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuThuoc> tieuSuThuocs;
    @OneToMany(mappedBy = "soKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LoiSongNguoiBenh> loiSongNguoiBenhs;
    @OneToMany(mappedBy = "soKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuDiUng> tieuSuDiUngs;
    @OneToMany(mappedBy = "soKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuPhauThuat> tieuSuPhauThuats;
    @OneToMany(mappedBy = "soKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuBenhTat> tieuSuBenhTats;
    @OneToMany(mappedBy = "soKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuBenhDiTruyen> tieuSuBenhDiTruyens;
    @OneToMany(mappedBy = "soKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LichSuKham> lichSuKhams;
}
