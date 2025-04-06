package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuPhauThuatDTO;
import com.mediaid.mediaid.model.TieuSuPhauThuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TieuSuPhauThuatRepo extends JpaRepository<TieuSuPhauThuat, String> {
    @Query("SELECT new com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuPhauThuatDTO(" +
            "a.tieuSuPhauThuatID, b.soKhamID, e.lyDoPhauThuatID, d.mucDoID, a.ten, a.thoiDiemThucHien, a.benhVienThucHien, a.bienChung, a.ghiChu) " +
            "FROM TieuSuPhauThuat a inner join a.soKham b inner join b.taiKhoan c inner join a.mucDo d inner join a.lyDoPhauThuat e " +
            "where c.accountID = ?1")
    List<TieuSuPhauThuatDTO> findPreviewByAccountID(String accounID);
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
