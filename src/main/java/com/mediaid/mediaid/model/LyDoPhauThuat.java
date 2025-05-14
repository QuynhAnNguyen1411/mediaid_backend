package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LyDoPhauThuat")
public class LyDoPhauThuat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lyDoPhauThuatID;
    @Column(nullable = false, unique = true)
    private String lyDo;

    private boolean status;

    public LyDoPhauThuat(String lyDo, boolean status) {
        this.lyDo = lyDo;
        this.status = status;
    }

    @OneToMany(mappedBy = "lyDoPhauThuat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuPhauThuat> tieuSuPhauThuats;
}