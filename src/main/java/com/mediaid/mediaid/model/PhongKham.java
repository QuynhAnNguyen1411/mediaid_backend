package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhongKham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phongKhamID;

    private String phongKham;
    private boolean isPhongKhamChanDoan;
    private int gioiHanLaySo;

    private boolean status;

    @OneToMany(mappedBy = "phongKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LichSuKhamChiTiet> lichSuKhamChiTiets;
    @OneToMany(mappedBy = "phongKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChanDoan> chanDoans;

}