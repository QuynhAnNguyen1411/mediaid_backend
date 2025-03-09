package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.NguoiGiamHo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiGiamHoRepo extends JpaRepository<NguoiGiamHo,String> {
}
