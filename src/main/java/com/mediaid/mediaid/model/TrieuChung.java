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
public class TrieuChung {
    @Id
    private String TrieuChungID;

    private String TrieuChung;
    private boolean status;

    public TrieuChung(String trieuChungID, String trieuChung, boolean status) {
        TrieuChungID = trieuChungID;
        TrieuChung = trieuChung;
        this.status = status;
    }

    @OneToMany(mappedBy = "trieuChung", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TrieuChungCuaBoPhan> trieuChungCuaBoPhans;
    @OneToMany(mappedBy = "trieuChung", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChanDoan> chanDoans;
}

