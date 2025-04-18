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
@AllArgsConstructor
public class PhanVungCoThe {
    @Id
    private String PhanVungID;

    private String Ten;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "phongKhamID")
    private PhongKham phongKham;

    @OneToMany(mappedBy = "phanVungCoThe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BoPhanCoThe> boPhanCoThes;
}

