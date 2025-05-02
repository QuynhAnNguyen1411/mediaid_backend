package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrangThaiKham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trangThaiKhamID;

    private String trangThai;

    public TrangThaiKham(String trangThai) {
        this.trangThai = trangThai;
    }

    @OneToMany(mappedBy = "trangThaiKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LichSuKham> lichSuKhams;
}