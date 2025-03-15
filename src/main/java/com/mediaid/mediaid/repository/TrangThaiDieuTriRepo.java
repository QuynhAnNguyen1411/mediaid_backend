package com.mediaid.mediaid.repository;


import com.mediaid.mediaid.model.TrangThaiDieuTri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrangThaiDieuTriRepo extends JpaRepository<TrangThaiDieuTri, Integer> {
    List<TrangThaiDieuTri> findByStatus(boolean status);

}
