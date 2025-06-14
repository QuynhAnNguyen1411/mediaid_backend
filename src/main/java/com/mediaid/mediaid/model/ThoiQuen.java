package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ThoiQuen")
public class ThoiQuen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int thoiQuenID;
    @Column(nullable = false, unique = true)
    private String ten;
    private boolean status;

    public ThoiQuen(String ten, boolean status) {
        this.ten = ten;
        this.status = status;
    }

    @OneToMany(mappedBy = "thoiQuen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ThoiQuenLoiSong> thoiQuenLoiSongs;
}