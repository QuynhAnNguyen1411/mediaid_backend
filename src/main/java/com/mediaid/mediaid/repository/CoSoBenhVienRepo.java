package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.CoSoBenhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CoSoBenhVienRepo extends JpaRepository<CoSoBenhVien, String> {
}
