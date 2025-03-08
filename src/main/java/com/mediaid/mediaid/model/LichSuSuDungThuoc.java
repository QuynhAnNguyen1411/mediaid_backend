package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LichSuSuDungThuoc {
    @Id
    private String lichSuSuDungThuocID;

    @ManyToOne
    @JoinColumn(name = "lichSuKhamID")
    private LichSuKham lichSuKham;

    private String tenThuoc;
    private Double lieuLuong;
    private String donVi;
    private String huongDanSuDung;
}