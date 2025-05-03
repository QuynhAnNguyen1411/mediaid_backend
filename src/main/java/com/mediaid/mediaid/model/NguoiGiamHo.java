package com.mediaid.mediaid.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NguoiGiamHo {
    @Id
    private String giamHoID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "soKhamID", nullable = false)
    private SoKham soKham;

    private String ten;
    private String cccdCmt;
    private String moiQuanHe;
    private String sdt;


}