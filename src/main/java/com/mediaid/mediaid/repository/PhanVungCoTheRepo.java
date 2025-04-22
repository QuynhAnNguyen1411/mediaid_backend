package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.PhanVungCoThe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PhanVungCoTheRepo extends JpaRepository<PhanVungCoThe, String> {
}
