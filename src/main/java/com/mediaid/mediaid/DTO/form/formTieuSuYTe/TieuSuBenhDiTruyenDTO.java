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
public class TieuSuBenhDiTruyenDTO {
    @JsonProperty("geneticDiseaseHistoryID")
    private String tieuSuBenhDiTruyenID;
    @NotNull
    @NotEmpty
    @JsonProperty("accountID")
    private String accountID;
    @JsonProperty("soKhamID")
    private String soKhamID;
    @NotNull
    @JsonProperty("medicalLevelFM")
    private Integer mucDoID;
    @NotNull
    @NotEmpty
    @JsonProperty("geneticDisease")
    private String loaiBenh;
    @JsonProperty("relationshipFM")
    private String thanhVienGiaDinh;

    @JsonProperty("yearOfDiseaseFM")
    private String namPhatHien;

    @JsonProperty("noteDiseaseFM")
    private String ghiChu;
}
