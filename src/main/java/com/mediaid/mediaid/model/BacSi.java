package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BacSi {

    @Id
    private String bacSiID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountID", nullable = false)
    private TaiKhoan taiKhoan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coSoID", nullable = false)
    private CoSoBenhVien coSoBenhVien;
}