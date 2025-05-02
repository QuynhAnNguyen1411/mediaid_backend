package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.PhongKhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PhongKhamChiTietRepo extends JpaRepository<PhongKhamChiTiet, String> {
}
