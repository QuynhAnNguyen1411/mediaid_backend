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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "soKhamID", nullable = false)
    private SoKham soKham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mucDoID", nullable = false)
    private MucDo mucDo;
    @Column(nullable = false)
    private String loaiBenh;

    private String thanhVienGiaDinh;

    private String namPhatHien;

    private String ghiChu;
}