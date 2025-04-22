package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.BoPhanCoThe;
import com.mediaid.mediaid.model.TrieuChung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoPhanCoTheRepo extends JpaRepository<BoPhanCoThe, String> {
}
