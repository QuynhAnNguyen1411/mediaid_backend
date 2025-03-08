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

    private String tenLoai;
    private Double gia;
    private String status;

    @OneToMany(mappedBy = "dichVuKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LichSuKhamChiTiet> lichSuKhamChiTiets;

    @ManyToOne
    @JoinColumn(name = "mauLoaiKhamID", nullable = false)
    private MauLoaiKham mauLoaiKham;
}