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
    @JsonProperty(namespace = "typeOfDisease")
    private String tieuSuBenhTatID;
    @NotNull
    @NotEmpty
    @JsonProperty(namespace = "treatmentMethod")
    private String soKhamID;
    @NotNull
    @JsonProperty(namespace = "medicalLevel")
    private int mucDoID;
    @NotNull
    @JsonProperty(namespace = "treatmentMethod")
    private int phuongPhapDieuTriID;
    @NotNull
    @NotEmpty
    @JsonProperty(namespace = "typeOfDisease")
    private String loaiBenh;
    @JsonProperty(namespace = "complications")
    private String bienChung;
    @JsonProperty(namespace = "hospitalTreatment")
    private String benhVienDieuTri;
    @JsonProperty(namespace = "yearOfDiagnosis")
    private String namPhatHien;
    @JsonProperty(namespace = "noteDisease")
    private String ghiChu;
}
