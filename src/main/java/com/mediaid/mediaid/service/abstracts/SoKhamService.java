package com.mediaid.mediaid.service.abstracts;

import com.mediaid.mediaid.DTO.form.formTieuSuYTe.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface SoKhamService {
    ResponseEntity<?> capNhatTieuSuBenhTat(TieuSuBenhTatDTO tieuSuBenhTatDTO, BindingResult bindingResult);
    ResponseEntity<?> capNhatTieuSuBenhDiTruyen(TieuSuBenhDiTruyenDTO tieuSuBenhDiTruyenDTO, BindingResult bindingResult);
    ResponseEntity<?> capNhatTieuSuDiUng(TieuSuDiUngDTO tieuSuDiUngDTO, BindingResult bindingResult);
    ResponseEntity<?> capNhatTieuSuPhauThuat(TieuSuPhauThuatDTO tieuSuPhauThuatDTO, BindingResult bindingResult);
    ResponseEntity<?> capNhatTieuSuThuoc(TieuSuThuocDTO tieuSuThuocDTO, BindingResult bindingResult);
    ResponseEntity<?> capNhatTieuSuLoiSong(TieuSuLoiSongDTO tieuSuLoiSongDTO, BindingResult bindingResult);


    ResponseEntity<?> getSoKham(String accountID);
    ResponseEntity<?> getDanhSachTieuSuTheoLoai(String accountID, String type);
    ResponseEntity<?> deleteTieuSuTheoLoai(String tieuSuID, String type);
    ResponseEntity<?> getTieuSuLoiSong(String accountID);
}
