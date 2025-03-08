package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LichSuKham {
    @Id
    private String lichSuKhamID;

    @ManyToOne
    @JoinColumn(name = "soKhamID", nullable = false)
    private SoKham soKham;

    @ManyToOne
    @JoinColumn(name = "bacSiID")
    private BacSi bacSi;

    @ManyToOne
    @JoinColumn(name = "trangThaiKhamID")
    private TrangThaiKham trangThaiKham;

    @ManyToOne
    @JoinColumn(name = "dichVuBenhVienID")
    private DichVuBenhVien dichVuBenhVien;

    @OneToMany(mappedBy = "lichSuKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LichSuKhamChiTiet> lichSuKhamChiTiets;

    @OneToMany(mappedBy = "lichSuKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LichSuSuDungThuoc> lichSuSuDungThuocs;

    private Date ngayKham;
    private String ketLuan;
}