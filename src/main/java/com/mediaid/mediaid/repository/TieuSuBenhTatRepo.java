package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuBenhTatDTO;
import com.mediaid.mediaid.model.TieuSuBenhTat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TieuSuBenhTatRepo extends JpaRepository<TieuSuBenhTat, String> {
    TieuSuBenhTat findByTieuSuBenhTatID(String id);
    @Query("SELECT new com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuBenhTatDTO(" +
                    "a.tieuSuBenhTatID, c.accountID, b.soKhamID, d.mucDoID, e.phuongPhapDieuTriID, a.loaiBenh, a.bienChung, a.benhVienDieuTri, a.namPhatHien, a.ghiChu) " +
                    "FROM TieuSuBenhTat a inner join a.soKham b inner join b.taiKhoan c inner join a.mucDo d inner join a.phuongPhapDieuTri e " +
                    "where c.accountID = ?1")
    List<TieuSuBenhTatDTO> findPreviewByAccountID(String accounID);
}
//    private String tieuSuBenhTatID;
//    private String accountID;
//    private String soKhamID;
//    private int mucDoID;
//    private int phuongPhapDieuTriID;
//    private String loaiBenh;
//    private String bienChung;
//    private String benhVienDieuTri;
//    private String namPhatHien;
//    private String ghiChu;

