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

    private String mucDo;

    private String status;

    @OneToMany(mappedBy = "mucDo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuDiUng> tieuSuDiUngs;

    @OneToMany(mappedBy = "mucDo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuPhauThuat> tieuSuPhauThuats;
}
