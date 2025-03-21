package com.mediaid.mediaid.DTO.form.formTieuSuYTe;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    private String tieuSuDiUngID;
    @NotNull
    @NotEmpty
    private String soKhamID;
    @NotNull
    @NotEmpty
    private int mucDoID;
    @NotNull
    @NotEmpty
    private String tacNhan;
    @NotNull
    @NotEmpty
    private String trieuChung;
    private String lanCuoiXayRa;
    private String ghiChu;
}
