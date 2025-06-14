package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.DanToc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanTocRepo extends JpaRepository<DanToc, Integer> {
    DanToc findByDanTocID(int id);
}
