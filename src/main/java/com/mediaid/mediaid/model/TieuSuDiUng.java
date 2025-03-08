package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TieuSuDiUng")
public class TieuSuDiUng {

    @Id
    private String tieuSuDiUngID;

    @ManyToOne
    @JoinColumn(name = "soKhamID", nullable = false)
    private SoKham soKham;

    @ManyToOne
    @JoinColumn(name = "mucDoDiUngID", nullable = false)
    private MucDo mucDo;

    private String tacNhan;

    private String trieuChung;

    private String lanCuoiXayRa;

    private String ghiChu;
}