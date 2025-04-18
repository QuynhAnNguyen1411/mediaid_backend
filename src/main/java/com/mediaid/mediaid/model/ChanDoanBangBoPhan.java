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
public class ChanDoanBangBoPhan {
    @Id
    private String chanDoanBPID;

    @ManyToOne
    @JoinColumn(name = "phongKhamID")
    private PhongKham phongKham;
    @ManyToOne
    @JoinColumn(name = "boPhanID")
    private BoPhanCoThe boPhanCoThe;
}

