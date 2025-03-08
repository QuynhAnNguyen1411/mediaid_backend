package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LichSuKhamChiTiet {
    @Id
    private String lichSuKhamChiTietID;

    @ManyToOne
    @JoinColumn(name = "lichSuKhamID", nullable = false)
    private LichSuKham lichSuKham;

    @ManyToOne
    @JoinColumn(name = "dichVuKhamID", nullable = false)
    private DichVuKham dichVuKham;

    @ManyToOne
    @JoinColumn(name = "phongKhamID", nullable = false)
    private PhongKham phongKham;

    private Date ngayKham;
    private Double gia;
    private String tenDichVuKham;
}