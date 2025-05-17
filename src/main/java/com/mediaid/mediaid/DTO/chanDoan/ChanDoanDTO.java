package com.mediaid.mediaid.DTO.chanDoan;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChanDoanDTO {
    @JsonProperty("accountID")
    private String accountID;
    @JsonProperty("medicalFacilityID")
    private Integer coSoID;
    @JsonProperty("bodyPart1ID")
    private String phanVungID;
    @JsonProperty("bodyPart2ID")
    private String boPhanID;
    @JsonProperty("symptomList")
    private List<String> TrieuChungID;
}
