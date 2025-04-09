package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LoaiSanPham")
public class LoaiSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loaiSanPhamID;

    private String loaiSanPham;
    private boolean status;

    public LoaiSanPham(String loaiSanPham, boolean status) {
        this.loaiSanPham = loaiSanPham;
        this.status = status;
    }

    @OneToMany(mappedBy = "loaiSanPham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuThuoc> tieuSuThuocs;
}
