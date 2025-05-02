package com.mediaid.mediaid.DTO.chanDoan;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChanDoanDTO {
    @NotNull
    @NotEmpty
    private String phanVungID;
    private String boPhanID;
    private String TrieuChungID;
}
