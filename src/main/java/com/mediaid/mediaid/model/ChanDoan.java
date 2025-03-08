package com.mediaid.mediaid.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ChanDoan")
public class ChanDoan {

    @Id
    private String chanDoanID;

    @ManyToOne
    @JoinColumn(name = "phongKhamID", nullable = false)
    private PhongKham phongKham;

    @ManyToOne
    @JoinColumn(name = "boPhanID", nullable = false)
    private BoPhanCoThe boPhanCoThe;
}

