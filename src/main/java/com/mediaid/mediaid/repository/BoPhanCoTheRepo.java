package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.BoPhanCoThe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BoPhanCoTheRepo extends JpaRepository<BoPhanCoThe, String> {
    @Query(nativeQuery = true, value = "SELECT * from mediate_db.bo_phan_co_the a order by CAST(SUBSTRING_INDEX(a.bo_phanid, '_', -1) AS UNSIGNED) asc ")
    List<BoPhanCoThe> findAllAndOrder();
    @Query(nativeQuery = true, value = "Select * from mediate_db.bo_phan_co_the a " +
            "where a.status = ?1 AND (a.gioi_tinhid IS null OR a.gioi_tinhid = ?2) " +
            "AND a.phan_vung_co_theid = ?3")
    List<BoPhanCoThe> findByStatusAndGioiTinhIDAndPhanVungID(boolean status, int gioiTinhID, String phanVungID);
}
