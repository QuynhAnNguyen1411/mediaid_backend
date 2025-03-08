package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MauLoaiKham")
public class MauLoaiKham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mauLoaiKhamID;

    private String mau;
    @OneToMany(mappedBy = "mauLoaiKham", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DichVuKham> dichVuKhams;
}
