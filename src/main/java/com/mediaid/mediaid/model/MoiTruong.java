package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MoiTruong")
public class MoiTruong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int moiTruongID;

    private String ten;
    private boolean status;

    @OneToMany(mappedBy = "moiTruong", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LoiSongNguoiBenh> loiSongNguoiBenhs;
}