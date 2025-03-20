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
public class TieuSuBenhTatDTO {
    private String tieuSuBenhTatID;
    @NotNull
    @NotEmpty
    private String soKhamID;
    @NotNull
    @NotEmpty
    private int mucDoID;
    @NotNull
    @NotEmpty
    private int phuongPhapDieuTriID;
    @NotNull
    @NotEmpty
    private String loaiBenh;
    private String bienChung;
    private String benhVienDieuTri;
    private String namPhatHien;
    private String ghiChu;
}
