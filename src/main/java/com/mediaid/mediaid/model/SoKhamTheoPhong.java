package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SoKhamTheoPhong {

    @Id
    private String soKhamTheoPhongID;
    private int soKhamTheoPhong;
    private LocalDate date;
    private String tinhTrangKham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phongKhamChiTietID")
    private PhongKhamChiTiet phongKhamChiTiet;

}