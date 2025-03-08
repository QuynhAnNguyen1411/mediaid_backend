package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TrangThaiDieuTri")
public class TrangThaiDieuTri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trangThaiDieuTriID;

    private String ten;

    private String status;

    @OneToMany(mappedBy = "trangThaiDieuTri", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuBenhTat> tieuSuBenhTats;
    @OneToMany(mappedBy = "trangThaiDieuTri", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuBenhDiTruyen> tieuSuBenhDiTruyens;
}
