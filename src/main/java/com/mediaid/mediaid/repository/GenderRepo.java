package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.GioiTinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenderRepo extends JpaRepository<GioiTinh, Integer> {
    List<GioiTinh> findByGioiTinhID(int id);
}
