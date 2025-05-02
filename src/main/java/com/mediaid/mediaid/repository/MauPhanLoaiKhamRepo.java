package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.MauLoaiKham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MauPhanLoaiKhamRepo extends JpaRepository<MauLoaiKham, String> {
}
