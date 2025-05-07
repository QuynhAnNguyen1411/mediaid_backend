package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LichSuKhamChiTiet {
    @Id
    private String lichSuKhamChiTietID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lichSuKhamID", nullable = false)
    private LichSuKham lichSuKham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phongKhamChiTietID", nullable = false)
    private PhongKhamChiTiet phongKhamChiTiet;

    private LocalDateTime ngayKham;
    private int soKhamThuTu;
    private LocalDateTime ngayKetLuan;
    private String anhKetQua;
    private String ghiChu;
    private double gia;
    private String tenDichVuKham;
}