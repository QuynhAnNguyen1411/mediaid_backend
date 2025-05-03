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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "soKhamID", nullable = false)
    private SoKham soKham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mucDoID", nullable = false)
    private MucDo mucDo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phuongPhapDieuTriID", nullable = false)
    private PhuongPhapDieuTri phuongPhapDieuTri;

    private String loaiBenh;

    private String bienChung;

    private String benhVienDieuTri;

    private String namPhatHien;

    private String ghiChu;
}