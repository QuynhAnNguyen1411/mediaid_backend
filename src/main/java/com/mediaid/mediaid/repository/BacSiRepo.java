package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.BacSi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BacSiRepo extends JpaRepository<BacSi, String> {
}
