package com.mediaid.mediaid.DTO.staticData.TieuSuYte;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FormCapNhatTieuSuYTe {
    List<TieuSuBenhDiTruyenDTO> tieuSuBenhDiTruyenDTOS;
    List<TieuSuBenhTatDTO> tieuSuBenhTatDTOS;
}
