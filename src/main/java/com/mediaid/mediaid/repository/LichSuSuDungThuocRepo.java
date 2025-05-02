package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.LichSuSuDungThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LichSuSuDungThuocRepo extends JpaRepository<LichSuSuDungThuoc, String> {
}
