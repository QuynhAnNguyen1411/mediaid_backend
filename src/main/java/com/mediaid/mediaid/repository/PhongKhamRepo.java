package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.PhongKham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PhongKhamRepo extends JpaRepository<PhongKham, String> {
    @Query(nativeQuery = true, value = "SELECT * from mediate_db.phong_kham a order by CAST(SUBSTRING_INDEX(a.phong_khamid, '_', -1) AS UNSIGNED) asc ")
    List<PhongKham> findAllAndOrder();
//    List<PhuongPhapDieuTri> findByStatus(boolean status);
//    PhuongPhapDieuTri findByPhuongPhapDieuTriID(int id);
}
