package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TieuSuPhauThuat")
public class TieuSuPhauThuat {

    @Id
    private String tieuSuPhauThuatID;

    @ManyToOne
    @JoinColumn(name = "soKhamID", nullable = false)
    private SoKham soKham;

    @ManyToOne
    @JoinColumn(name = "lyDoPhauThuatID", nullable = false)
    private LyDoPhauThuat lyDoPhauThuat;

    @ManyToOne
    @JoinColumn(name = "mucDoPhauThuatID", nullable = false)
    private MucDo mucDo;

    private String ten;

    private String thoiDiemThucHien;

    private String benhVienThucHien;

    private String bienChung;

    private String ghiChu;
}
