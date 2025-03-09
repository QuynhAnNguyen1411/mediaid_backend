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
public class DanToc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int danTocID;

    private String title;
    @OneToMany(mappedBy = "danToc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts;

    public DanToc(String title) {
        this.title = title;
    }
}

