package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.SoKham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoKhamRepo extends JpaRepository<SoKham, String> {
    SoKham findBySoKhamId(String id);
}
