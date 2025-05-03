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
public class ChanDoanBangBoPhan {
    @Id
    private String chanDoanBPID;
    private boolean coTrieuChung;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boPhanID", nullable = false)
    private BoPhanCoThe boPhanCoThe;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phongKhamID", nullable = false)
    private PhongKham phongKham;


}

