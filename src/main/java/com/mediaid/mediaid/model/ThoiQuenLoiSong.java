package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ThoiQuenLoiSong")
public class ThoiQuenLoiSong {

    @Id
    private String thoiQuenLoiSongID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "thoiQuenID", nullable = false)
    private ThoiQuen thoiQuen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loiSongNguoiBenhID", nullable = false)
    private LoiSongNguoiBenh loiSongNguoiBenh;
}