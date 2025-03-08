package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LoiSongNguoiBenh")
public class LoiSongNguoiBenh {

    @Id
    private String loiSongNguoiBenhID;

    @ManyToOne
    @JoinColumn(name = "soKhamID", nullable = false)
    private SoKham soKham;

    @ManyToOne
    @JoinColumn(name = "moiTruongID")
    private MoiTruong moiTruong;

    @OneToMany(mappedBy = "loiSongNguoiBenh", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ThoiQuenLoiSong> thoiQuenLoiSongs;

    private String ghiChu;
}
