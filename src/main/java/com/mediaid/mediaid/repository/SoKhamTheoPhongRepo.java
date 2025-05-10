package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.SoKhamTheoPhong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface SoKhamTheoPhongRepo extends JpaRepository<SoKhamTheoPhong, String> {
    @Query(nativeQuery = true, value = "SELECT MAX(so_kham_theo_phong) " +
            "FROM mediate_db.so_kham_theo_phong " +
            "where phong_kham_chi_tietid = ?1 AND date = ?2;")
    Integer findLastestNumberOfPhongKhamChiTiet(String phongKhamChiTietID, LocalDate date);
}
