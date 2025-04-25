package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.TrieuChung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TrieuChungRepo extends JpaRepository<TrieuChung, String> {
    @Query(nativeQuery = true, value = "SELECT * from mediate_db.trieu_chung a order by CAST(SUBSTRING_INDEX(a.trieu_chungid, '_', -1) AS UNSIGNED) asc ")
    List<TrieuChung> findAllAndOrder();
    @Query(nativeQuery = true, value = "SELECT a.* FROM mediate_db.trieu_chung a " +
            "right join mediate_db.trieu_chung_cua_bo_phan b " +
            "on a.trieu_chungid = b.trieu_chungid " +
            "where b.bo_phan_co_theid = ?2 AND a.status = ?1 ")
    List<TrieuChung> findByStatusAndBoPhanID(boolean status, String boPhanID);
}
