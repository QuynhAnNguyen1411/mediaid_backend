package com.mediaid.mediaid.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TieuSuBenhTat")
public class TieuSuBenhTat {

    @Id
    private String tieuSuBenhTatID;

    @ManyToOne
    @JoinColumn(name = "soKhamID", nullable = false)
    private SoKham soKham;

    @ManyToOne
    @JoinColumn(name = "trangThaiDieuTriID", nullable = false)
    private TrangThaiDieuTri trangThaiDieuTri;

    @ManyToOne
    @JoinColumn(name = "phuongPhapDieuTriID", nullable = false)
    private PhuongPhapDieuTri phuongPhapDieuTri;

    private String loaiBenh;

    private String bienChung;

    private String benhVienDieuTri;

    private String namPhatHien;

    private String ghiChu;
}