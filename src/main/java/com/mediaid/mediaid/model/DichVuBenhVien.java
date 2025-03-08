package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DichVuBenhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dichVuBenhVienID;

    private String ten;
    private String status;

    @OneToMany(mappedBy = "dichVuBenhVien", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LichSuKham> lichSuKhams;
}
