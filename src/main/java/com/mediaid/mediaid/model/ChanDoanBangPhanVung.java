package com.mediaid.mediaid.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name = "phanVungID", nullable = false)
    private PhanVungCoThe phanVungCoThe;
    @ManyToOne
    @JoinColumn(name = "phongKhamID", nullable = false)
    private PhongKham phongKham;

}

