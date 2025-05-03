package com.mediaid.mediaid.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}

