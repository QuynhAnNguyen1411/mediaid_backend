package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.TrangThaiKham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrangThaiKhamSoBoRepo extends JpaRepository<TrangThaiKham, Integer> {
}
