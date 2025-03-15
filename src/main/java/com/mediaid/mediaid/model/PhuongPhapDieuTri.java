package com.mediaid.mediaid.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PhuongPhapDieuTri")
public class PhuongPhapDieuTri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phuongPhapDieuTriID;

    private String ten;

    private boolean status;

    @OneToMany(mappedBy = "phuongPhapDieuTri", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuBenhTat> tieuSuBenhTats;
}