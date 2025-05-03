package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoan {
    @Id
    private String accountID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "danTocID", nullable = false)
    private DanToc danToc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gioiTinhID", nullable = false)
    private GioiTinh gioiTinh;

    @OneToOne(mappedBy = "taiKhoan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private SoKham soKham;

    private String ten;
    private Date ngaySinh;
    @Column(unique = true, nullable = false)
    private String cccdCmt;
    private String diaChi;
    @Column(unique = true, nullable = false)
    private String sdt;
    private String email;
    private String matKhau;
}