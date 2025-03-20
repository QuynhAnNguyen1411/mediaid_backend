package com.mediaid.mediaid.service.abstracts;

import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuBenhTatDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface SoKhamService {
    ResponseEntity<?> capNhatTieuSuBenhTat(TieuSuBenhTatDTO tieuSuBenhTatDTO, BindingResult bindingResult);
}
