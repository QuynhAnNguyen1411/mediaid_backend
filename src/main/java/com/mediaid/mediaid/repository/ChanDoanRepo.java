package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.ChanDoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChanDoanRepo extends JpaRepository<ChanDoan, String> {
}
