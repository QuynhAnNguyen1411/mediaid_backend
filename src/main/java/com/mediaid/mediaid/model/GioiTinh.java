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
public class GioiTinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gioiTinhID;

    private String title;
    @OneToMany(mappedBy = "gioiTinh", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts;
}