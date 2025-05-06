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
public class TrieuChungCuaBoPhan {
    @Id
    private String TrieuChungBoPhanID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TrieuChungID")
    private TrieuChung trieuChung;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boPhanCoTheID")
    private BoPhanCoThe boPhanCoThe;

    @OneToMany(mappedBy = "trieuChungCuaBoPhan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChanDoanBangBoPhanVaTrieuChung> chanDoanBangBoPhanVaTrieuChungs;

    public TrieuChungCuaBoPhan(String trieuChungBoPhanID, TrieuChung trieuChung, BoPhanCoThe boPhanCoThe) {
        TrieuChungBoPhanID = trieuChungBoPhanID;
        this.trieuChung = trieuChung;
        this.boPhanCoThe = boPhanCoThe;
    }
}

