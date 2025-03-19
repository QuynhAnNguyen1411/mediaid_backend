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
public class TieuSuBenhTatDTO {
    private String tieuSuBenhTatID;
    private String soKhamID;
    private int mucDoID;
    private int phuongPhapDieuTriID;
    private String loaiBenh;
    private String bienChung;
    private String benhVienDieuTri;
    private String namPhatHien;
    private String ghiChu;
}
