package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TieuSuBenhDiTruyen")
public class TieuSuBenhDiTruyen {

    @Id
    private String tieuSuBenhDiTruyenID;

    @ManyToOne
    @JoinColumn(name = "soKhamID", nullable = false)
    private SoKham soKham;

    @ManyToOne
    @JoinColumn(name="trangThaiThanhVienID")
    private TrangThaiDieuTri trangThaiDieuTri;

    private String loaiBenh;

    private String thanhVienThanhNien;

    private String moiQuanHeThanhVien;

    private String namPhatHien;

    private String ghiChu;
}