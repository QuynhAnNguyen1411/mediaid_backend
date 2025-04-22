package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SoKhamTheoPhong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int soKhamTheoPhongID;
    private int soKhamTheoPhong;
    private Date date;
    private String tinhTrangKham;

    @ManyToOne
    @JoinColumn(name = "phongKhamChiTietID")
    private PhongKhamChiTiet phongKhamChiTiet;

}