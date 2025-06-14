package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.LyDoPhauThuat;
import com.mediaid.mediaid.model.MucDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LyDoPhauThuatRepo extends JpaRepository<LyDoPhauThuat, Integer> {
    List<LyDoPhauThuat> findByStatus(boolean status);
    LyDoPhauThuat findByLyDoPhauThuatID(int id);
}
