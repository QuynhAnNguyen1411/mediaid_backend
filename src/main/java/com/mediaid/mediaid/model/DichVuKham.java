package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DichVuKham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dichVuKhamID;
    @Column(nullable = false, unique = true)
    private String tenLoai;
    @Column(nullable = false)
    private Double gia;
    private boolean status;

    public DichVuKham(String tenLoai, Double gia, boolean status, MauLoaiKham mauLoaiKham) {
        this.tenLoai = tenLoai;
        this.gia = gia;
        this.status = status;
        this.mauLoaiKham = mauLoaiKham;
    }

    @OneToMany(mappedBy = "dichVuKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PhongKham> phongKhams;

    @ManyToOne
    @JoinColumn(name = "mauLoaiKhamID", nullable = false)
    private MauLoaiKham mauLoaiKham;
}