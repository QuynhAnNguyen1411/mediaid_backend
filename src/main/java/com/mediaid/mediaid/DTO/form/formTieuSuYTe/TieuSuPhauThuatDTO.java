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
public class TieuSuPhauThuatDTO {
    @JsonProperty("surgeryHistoryID")
    private String tieuSuPhauThuatID;
    @NotNull
    @NotEmpty
    @JsonProperty("accountID")
    private String accountID;
    @JsonProperty("soKhamID")
    private String soKhamID;
    @JsonProperty("reasonSurgery")
    @NotNull
    private Integer lyDoPhauThuatID;
    @JsonProperty("surgeryLevel")
    @NotNull
    private Integer mucDoID;
    @JsonProperty("nameSurgery")
    @NotNull
    @NotEmpty
    private String ten;

    @JsonProperty("timeSurgery")
    @NotNull
    @NotEmpty
    private String thoiDiemThucHien;
    @JsonProperty("surgicalHospital")
    private String benhVienThucHien;
    @JsonProperty("complicationSurgery")
    private String bienChung;

    @JsonProperty("noteSurgery")
    private String ghiChu;
}
