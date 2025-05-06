package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.TrieuChungCuaBoPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface TrieuChungCuaBoPhanRepo extends JpaRepository<TrieuChungCuaBoPhan, String> {

    @Query(nativeQuery = true, value = "Select * from trieu_chung_cua_bo_phan a where a.bo_phan_co_theid = ?1 AND a.trieu_chungid = ?2")
    TrieuChungCuaBoPhan findByBoPhanIDAndTrieuChungID(String boPhanID, String trieuChungID);
}
