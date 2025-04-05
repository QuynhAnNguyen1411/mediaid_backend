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
public class TieuSuBenhTatDTO {
    @JsonProperty("medicalHistoryID")
    private String tieuSuBenhTatID;
    @NotNull
    @NotEmpty
    @JsonProperty("accountID")
    private String accountID;
    @JsonProperty("soKhamID")
    private String soKhamID;
    @NotNull
    @JsonProperty("medicalLevel")
    private int mucDoID;
    @NotNull
    @JsonProperty("treatmentMethod")
    private int phuongPhapDieuTriID;
    @NotNull
    @NotEmpty
    @JsonProperty("typeOfDisease")
    private String loaiBenh;
    @JsonProperty("complications")
    private String bienChung;
    @JsonProperty("hospitalTreatment")
    private String benhVienDieuTri;
    @JsonProperty("yearOfDiagnosis")
    private String namPhatHien;
    @JsonProperty("noteDisease")
    private String ghiChu;
}
