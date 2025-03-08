package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.DanToc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanTocRepo extends JpaRepository<DanToc, Integer> {
    List<DanToc> findByDanTocID(int id);
}
