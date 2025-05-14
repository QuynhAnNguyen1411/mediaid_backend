package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TinhTrangSuDung")
public class TinhTrangSuDung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tinhTrangSuDungID;
    @Column(nullable = false, unique = true)
    private String tinhTrang;
    private boolean status;

    public TinhTrangSuDung(String tinhTrang, boolean status) {
        this.tinhTrang = tinhTrang;
        this.status = status;
    }

    @OneToMany(mappedBy = "tinhTrangSuDung", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuThuoc> tieuSuThuocs;
}
