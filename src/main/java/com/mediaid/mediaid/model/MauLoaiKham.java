package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MauLoaiKham")
public class MauLoaiKham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mauLoaiKhamID;
    @Column(nullable = false, unique = true)
    private String mau;
    private String loaiDichVu;

    public MauLoaiKham(String mau, String loaiDichVu) {
        this.mau = mau;
        this.loaiDichVu = loaiDichVu;
    }

    @OneToMany(mappedBy = "mauLoaiKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DichVuKham> dichVuKhams;
}
