package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.PhuongPhapDieuTri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhuongPhapDieuTriRepo extends JpaRepository<PhuongPhapDieuTri, Integer> {
    List<PhuongPhapDieuTri> findByStatus(boolean status);
    PhuongPhapDieuTri findByPhuongPhapDieuTriId(int id);

}
