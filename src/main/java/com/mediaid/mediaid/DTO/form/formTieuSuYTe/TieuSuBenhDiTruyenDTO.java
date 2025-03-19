package com.mediaid.mediaid.DTO.form.formTieuSuYTe;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    private String soKhamID;
    private int mucDoID;
    private String loaiBenh;
    private String bienChung;
    private String quanHeThanhVien;
    private String namPhatHienThanhVien;
    private String ghiChu;
}
