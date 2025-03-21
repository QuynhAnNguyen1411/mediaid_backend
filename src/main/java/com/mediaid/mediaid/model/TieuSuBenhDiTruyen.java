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
    @JoinColumn(name = "mucDoID", nullable = false)
    private MucDo mucDo;

    private String loaiBenh;

    private String thanhVienGiaDinh;

    private String moiQuanHeThanhVien;

    private String namPhatHien;

    private String ghiChu;
}