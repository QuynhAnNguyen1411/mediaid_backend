package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MucDo")
public class MucDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mucDoID;
    @Column(nullable = false, unique = true)
    private String mucDo;

    private boolean status;

    public MucDo(String mucDo, boolean status) {
        this.mucDo = mucDo;
        this.status = status;
    }

    @OneToMany(mappedBy = "mucDo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuDiUng> tieuSuDiUngs;

    @OneToMany(mappedBy = "mucDo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuPhauThuat> tieuSuPhauThuats;
    @OneToMany(mappedBy = "mucDo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuBenhTat> tieuSuBenhTats;
    @OneToMany(mappedBy = "mucDo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuBenhDiTruyen> tieuSuBenhDiTruyens;
}
