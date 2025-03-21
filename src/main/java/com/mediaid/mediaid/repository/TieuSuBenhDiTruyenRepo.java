package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.TieuSuBenhDiTruyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TieuSuBenhDiTruyenRepo extends JpaRepository<TieuSuBenhDiTruyen, String> {
    TieuSuBenhDiTruyen findByTieuSuBenhDiTruyenID(String id);
}
