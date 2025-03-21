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
public class TieuSuBenhDiTruyenDTO {
    private String tieuSuBenhDiTruyenID;
    @NotNull
    @NotEmpty
    private String soKhamID;
    @NotNull
    private int mucDoID;
    @NotNull
    @NotEmpty
    private String loaiBenh;

    private String thanhVienGiaDinh;

    private String moiQuanHeThanhVien;

    private String namPhatHien;

    private String ghiChu;
}
