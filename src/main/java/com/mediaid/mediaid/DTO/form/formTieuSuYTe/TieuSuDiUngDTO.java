package com.mediaid.mediaid.DTO.form.formTieuSuYTe;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TieuSuDiUngDTO {
    @JsonProperty("allergyHistoryID")
    private String tieuSuDiUngID;
    @NotNull
    @NotEmpty
    @JsonProperty("accountID")
    private String accountID;
    @JsonProperty("soKhamID")
    private String soKhamID;
    @NotNull
    @JsonProperty("allergyLevel")
    private Integer mucDoID;
    @NotNull
    @NotEmpty
    @JsonProperty("allergicAgents")
    private String tacNhan;
    @NotNull
    @NotEmpty
    @JsonProperty("allergySymptoms")
    private String trieuChung;

    @JsonProperty("lastHappened")
    private String lanCuoiXayRa;
    @JsonProperty("noteAllergy")
    private String ghiChu;
}
