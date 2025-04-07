package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuBenhDiTruyenDTO;
import com.mediaid.mediaid.model.TieuSuBenhDiTruyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TieuSuBenhDiTruyenRepo extends JpaRepository<TieuSuBenhDiTruyen, String> {
    TieuSuBenhDiTruyen findByTieuSuBenhDiTruyenID(String id);
    @Query("SELECT new com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuBenhDiTruyenDTO(" +
            "a.tieuSuBenhDiTruyenID, c.accountID, b.soKhamID, d.mucDoID, a.loaiBenh, a.thanhVienGiaDinh, a.namPhatHien, a.ghiChu) " +
            "FROM TieuSuBenhDiTruyen a inner join a.soKham b inner join b.taiKhoan c inner join a.mucDo d " +
            "where c.accountID = ?1")
    List<TieuSuBenhDiTruyenDTO> findPreviewByAccountID(String accounID);
}
//    private String tieuSuBenhDiTruyenID;
//    private String soKhamID;
//    private int mucDoID;
//    private String loaiBenh;
//    private String thanhVienGiaDinh;
//    private String namPhatHien;
//    private String ghiChu;
