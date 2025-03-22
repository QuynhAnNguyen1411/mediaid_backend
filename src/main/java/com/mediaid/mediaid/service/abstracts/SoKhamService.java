package com.mediaid.mediaid.service.abstracts;

import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuBenhDiTruyenDTO;
import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuBenhTatDTO;
import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuDiUngDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface SoKhamService {
    ResponseEntity<?> capNhatTieuSuBenhTat(TieuSuBenhTatDTO tieuSuBenhTatDTO, BindingResult bindingResult);
    ResponseEntity<?> capNhatTieuSuBenhDiTruyen(TieuSuBenhDiTruyenDTO tieuSuBenhDiTruyenDTO, BindingResult bindingResult);
    ResponseEntity<?> capNhatTieuSuDiUng(TieuSuDiUngDTO tieuSuDiUngDTO, BindingResult bindingResult);
    ResponseEntity<?> getSoKham(String accountID);

}
