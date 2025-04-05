package com.mediaid.mediaid.DTO.form.formTieuSuYTe;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mediaid.mediaid.model.LyDoPhauThuat;
import com.mediaid.mediaid.model.MucDo;
import com.mediaid.mediaid.model.SoKham;
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
    private String tieuSuPhauThuatID;
    @NotNull
    @NotEmpty
    private SoKham soKham;
    @NotNull
    @NotEmpty
    private LyDoPhauThuat lyDoPhauThuatID;
    @NotNull
    @NotEmpty
    private MucDo mucDoID;
    @NotNull
    @NotEmpty
    private String ten;
    @NotNull
    @NotEmpty
    private String thoiDiemThucHien;
    @NotNull
    @NotEmpty
    private String benhVienThucHien;
    private String bienChung;
    private String ghiChu;
}
