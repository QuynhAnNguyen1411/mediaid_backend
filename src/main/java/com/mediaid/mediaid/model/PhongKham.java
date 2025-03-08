package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PhongKham")
public class PhongKham {

    @Id
    private int phongKhamID;

    private String phongKham;

    private String status;

    @OneToMany(mappedBy = "phongKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LichSuKhamChiTiet> lichSuKhamChiTiets;
    @OneToMany(mappedBy = "phongKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChanDoan> chanDoans;

}