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
    @Query(nativeQuery = true, value = "select * from trieu_chung")
    List<TrieuChung> findByStatusAndBoPhanID(boolean status, String boPhanID);
}
