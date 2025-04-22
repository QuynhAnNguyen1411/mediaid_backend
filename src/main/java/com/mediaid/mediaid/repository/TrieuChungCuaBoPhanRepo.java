package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.TrieuChungCuaBoPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrieuChungCuaBoPhanRepo extends JpaRepository<TrieuChungCuaBoPhan, String> {
}
