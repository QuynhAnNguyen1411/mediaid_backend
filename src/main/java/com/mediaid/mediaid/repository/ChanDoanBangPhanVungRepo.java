package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.ChanDoanBangPhanVung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChanDoanBangPhanVungRepo extends JpaRepository<ChanDoanBangPhanVung, String> {
}
