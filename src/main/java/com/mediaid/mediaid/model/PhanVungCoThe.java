package com.mediaid.mediaid.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PhanVungCoThe {
    @Id
    private String PhanVungID;
    @Column(unique = true)
    private String Ten;
    private boolean status;

    public PhanVungCoThe(String phanVungID, String ten, boolean status, PhongKham phongKham) {
        PhanVungID = phanVungID;
        Ten = ten;
        this.status = status;
        this.phongKham = phongKham;
    }

    @ManyToOne
    @JoinColumn(name = "phongKhamID")
    private PhongKham phongKham;

    @OneToMany(mappedBy = "phanVungCoThe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BoPhanCoThe> boPhanCoThes;
    @OneToMany(mappedBy = "phanVungCoThe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChanDoan> chanDoans;
}

