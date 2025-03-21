package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.TieuSuDiUng;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TieuSuDiUngRepo extends JpaRepository<TieuSuDiUng, String> {
    TieuSuDiUng findByTieuSuDiUngId(String id);
}
