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
public class ChanDoan {
    @Id
    private String chanDoanBPID;

    @ManyToOne
    @JoinColumn(name = "phongKhamID", nullable = false)
    private PhongKham phongKham;
    @ManyToOne
    @JoinColumn(name = "phanVungID")
    private PhanVungCoThe phanVungCoThe;

    @ManyToOne
    @JoinColumn(name = "boPhanID")
    private BoPhanCoThe boPhanCoThe;
    @ManyToOne
    @JoinColumn(name = "trieuChungID")
    private TrieuChung trieuChung;
}

