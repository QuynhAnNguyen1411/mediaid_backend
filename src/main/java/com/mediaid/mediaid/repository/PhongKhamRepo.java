package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.PhongKham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PhongKhamRepo extends JpaRepository<PhongKham, String> {
//    List<PhuongPhapDieuTri> findByStatus(boolean status);
//    PhuongPhapDieuTri findByPhuongPhapDieuTriID(int id);
}
