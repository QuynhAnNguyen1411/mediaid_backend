package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.DichVuKham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DichVuKhamRepo extends JpaRepository<DichVuKham, Integer> {
}
