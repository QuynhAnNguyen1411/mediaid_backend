package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.TieuSuBenhTat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TieuSuBenhTatRepo extends JpaRepository<TieuSuBenhTat, String> {
    TieuSuBenhTat findByTieuSuBenhTatId(String id);

}
