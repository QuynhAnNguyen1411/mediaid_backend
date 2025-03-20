package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.MucDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MucDoRepo extends JpaRepository<MucDo, Integer> {
    List<MucDo> findByStatus(boolean status);
    MucDo findByMucDoId(int id);

}
