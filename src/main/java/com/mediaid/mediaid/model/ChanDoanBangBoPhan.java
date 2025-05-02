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
    private boolean coTrieuChung;
    @ManyToOne
    @JoinColumn(name = "boPhanID", nullable = false)
    private BoPhanCoThe boPhanCoThe;
    @ManyToOne
    @JoinColumn(name = "phongKhamID", nullable = false)
    private PhongKham phongKham;


}

