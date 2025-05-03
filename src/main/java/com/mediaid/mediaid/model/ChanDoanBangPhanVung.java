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
public class ChanDoanBangPhanVung {
    @Id
    private String chanDoanPVID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phanVungID", nullable = false)
    private PhanVungCoThe phanVungCoThe;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phongKhamID", nullable = false)
    private PhongKham phongKham;

}

