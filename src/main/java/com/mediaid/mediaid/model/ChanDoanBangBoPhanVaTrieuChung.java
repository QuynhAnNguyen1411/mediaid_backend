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
public class ChanDoanBangBoPhanVaTrieuChung {
    @Id
    private String chanDoanBPID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TCcuaBPID", nullable = false)
    private TrieuChungCuaBoPhan trieuChungCuaBoPhan;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phongKhamID", nullable = false)
    private PhongKham phongKham;
    @Column(nullable = false)
    private int ESI;
}

