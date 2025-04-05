package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuDiUngDTO;
import com.mediaid.mediaid.model.TieuSuDiUng;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TieuSuDiUngRepo extends JpaRepository<TieuSuDiUng, String> {
    TieuSuDiUng findByTieuSuDiUngID(String id);
    @Query("SELECT new com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuDiUngDTO(" +
            "a.tieuSuDiUngID, b.soKhamID, d.mucDoID, a.tacNhan, a.trieuChung, a.lanCuoiXayRa, a.ghiChu) " +
            "FROM TieuSuDiUng a inner join a.soKham b inner join b.taiKhoan c inner join a.mucDo d " +
            "where c.accountID = ?1")
    List<TieuSuDiUngDTO> findPreviewByAccountID(String accounID);
}
//    private String tieuSuDiUngID;
//    private String soKhamID;
//    private int mucDoID;
//    private String tacNhan;
//    private String trieuChung;
//    private String lanCuoiXayRa;
//    private String ghiChu;
