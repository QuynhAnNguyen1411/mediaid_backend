package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BaoTri")
public class BacSi {

    @Id
    private String bacSiID;

    @OneToOne
    @JoinColumn(name = "accountID", nullable = false)
    private TaiKhoan taiKhoan;

    @ManyToOne
    @JoinColumn(name = "coSoID", nullable = false)
    private CoSoBenhVien coSoBenhVien;
}