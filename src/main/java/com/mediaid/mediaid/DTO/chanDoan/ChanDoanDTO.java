package com.mediaid.mediaid.DTO.chanDoan;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChanDoanDTO {
    private String accountID;
    private Integer coSoID;
    private String phanVungID;
    private String boPhanID;
    private List<String> TrieuChungID;
}
