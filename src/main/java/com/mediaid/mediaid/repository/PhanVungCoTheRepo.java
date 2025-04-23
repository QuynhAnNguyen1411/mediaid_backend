package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.PhanVungCoThe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PhanVungCoTheRepo extends JpaRepository<PhanVungCoThe, String> {
    @Query(nativeQuery = true, value = "SELECT * from mediate_db.phan_vung_co_the a order by CAST(SUBSTRING_INDEX(a.phan_vungid, '_', -1) AS UNSIGNED) asc ")
    List<PhanVungCoThe> findAllAndOrder();
    List<PhanVungCoThe> findByStatus(boolean status);
}
