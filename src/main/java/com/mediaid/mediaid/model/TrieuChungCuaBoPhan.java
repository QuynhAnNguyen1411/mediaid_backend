package com.mediaid.mediaid.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "boPhanCoTheID")
    private BoPhanCoThe boPhanCoThe;
    @ManyToOne
    @JoinColumn(name = "TrieuChungID")
    private TrieuChung trieuChung;
}

