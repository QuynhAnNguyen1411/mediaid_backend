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
public class Account {
    @Id
    private String accountID;

    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "danTocID", nullable = false)
    private DanToc danToc;

    @ManyToOne
    @JoinColumn(name = "gioiTinhID", nullable = false)
    private GioiTinh gioiTinh;

    private String ten;
    private Date ngaySinh;
    private String cccdCmt;
    private String diaChi;
    private String sdt;
    private String email;
}