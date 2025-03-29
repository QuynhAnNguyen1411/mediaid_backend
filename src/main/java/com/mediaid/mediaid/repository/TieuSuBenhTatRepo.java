package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.DTO.staticData.TieuSuPreviewData;
import com.mediaid.mediaid.model.TieuSuBenhTat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TieuSuBenhTatRepo extends JpaRepository<TieuSuBenhTat, String> {
    TieuSuBenhTat findByTieuSuBenhTatID(String id);
    @Query("SELECT new com.mediaid.mediaid.DTO.staticData.TieuSuPreviewData(a.tieuSuBenhTatID, a.loaiBenh, a.namPhatHien) FROM TieuSuBenhTat a inner join a.soKham b inner join b.taiKhoan c where c.accountID = ?1")
    List<TieuSuPreviewData> findPreviewByAccountID(String accounID);
}
