package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.ChanDoanBangBoPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChanDoanBangBoPhanRepo extends JpaRepository<ChanDoanBangBoPhan, String> {
}
