package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuPhauThuatDTO;
import com.mediaid.mediaid.model.TieuSuPhauThuat;
import com.mediaid.mediaid.model.TinhTrangSuDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TinhTrangSuDungRepo extends JpaRepository<TinhTrangSuDung, Integer> {
    TinhTrangSuDung findByTinhTrangSuDungID(int id);
}
//    private String tieuSuPhauThuatID;
//    private String soKhamID;
//    private int lyDoPhauThuatID;
//    private int mucDoID;
//    private String ten;
//    private String thoiDiemThucHien;
//    private String benhVienThucHien;
//    private String bienChung;
//    private String ghiChu;
