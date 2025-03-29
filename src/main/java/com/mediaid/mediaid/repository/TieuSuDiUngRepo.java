package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.DTO.staticData.TieuSuPreviewData;
import com.mediaid.mediaid.model.TieuSuDiUng;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TieuSuDiUngRepo extends JpaRepository<TieuSuDiUng, String> {
    TieuSuDiUng findByTieuSuDiUngID(String id);
    @Query("SELECT new com.mediaid.mediaid.DTO.staticData.TieuSuPreviewData(a.tieuSuDiUngID, a.tacNhan, a.lanCuoiXayRa) FROM TieuSuDiUng a inner join a.soKham b inner join b.taiKhoan c where c.accountID = ?1")
    List<TieuSuPreviewData> findPreviewByAccountID(String accounID);
}
