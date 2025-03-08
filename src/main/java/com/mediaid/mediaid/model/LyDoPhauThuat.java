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

    private String lyDo;

    private String status;

    @OneToMany(mappedBy = "lyDoPhauThuat", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuPhauThuat> tieuSuPhauThuats;
}