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
public class BoPhanCoThe {
    @Id
    private String BoPhanID;

    private String Ten;
    private boolean status;

    @OneToMany(mappedBy = "boPhanCoThe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChanDoan> chanDoans;
}

