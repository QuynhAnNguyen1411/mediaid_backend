package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TieuSuThuoc")
public class TieuSuThuoc {

    @Id
    private String tieuSuThuocID;

    @ManyToOne
    @JoinColumn(name = "soKhamID", nullable = false)
    private SoKham soKham;

    @ManyToOne
    @JoinColumn(name = "tinhTrangSuDungID", nullable = false)
    private TinhTrangSuDung tinhTrangSuDung;
    @ManyToOne
    @JoinColumn(name = "loaiSanPhamID", nullable = false)
    private LoaiSanPham loaiSanPham;

    private String tenThuoc;
    private String batDau;
    private String ketThuc;
    private String ghiChu;
}