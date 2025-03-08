package com.mediaid.mediaid.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoSoBenhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CoSoID;

    private String ten;
    private String diaChi;

    @OneToMany(mappedBy = "coSoBenhVien", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BacSi> bacSis;
}

