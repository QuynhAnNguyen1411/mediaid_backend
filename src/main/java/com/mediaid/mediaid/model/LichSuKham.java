package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LichSuKham {
    @Id
    private String lichSuKhamID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "soKhamID", nullable = false)
    private SoKham soKham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bacSiID")
    private BacSi bacSi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trangThaiKhamID")
    private TrangThaiKham trangThaiKham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coSoID")
    private CoSoBenhVien coSoBenhVien;

    @OneToMany(mappedBy = "lichSuKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LichSuKhamChiTiet> lichSuKhamChiTiets;

    @OneToMany(mappedBy = "lichSuKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LichSuSuDungThuoc> lichSuSuDungThuocs;

    private LocalDateTime ngayKham;
    private LocalDateTime ngayKetLuan;
    private Double tongThu;
    private String ketLuan;
    private String ghiChu;
}