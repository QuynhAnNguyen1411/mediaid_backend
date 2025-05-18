package com.mediaid.mediaid.DTO.chanDoan;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class KetQuaChanDoanDTO {
    private String LichSuKhamID;
    private String message;
}
