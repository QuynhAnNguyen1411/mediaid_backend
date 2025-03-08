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
    private String tinhTrangSuDungID;

    private String tinhTrang;

    @OneToMany(mappedBy = "tinhTrangSuDung", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TieuSuThuoc> tieuSuThuocs;
}
