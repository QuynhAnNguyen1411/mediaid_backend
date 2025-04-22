package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.TrieuChung;
import com.mediaid.mediaid.model.TrieuChungCuaBoPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrieuChungRepo extends JpaRepository<TrieuChung, String> {
}
