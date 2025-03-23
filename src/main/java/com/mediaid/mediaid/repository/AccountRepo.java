package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<TaiKhoan, String> {
    TaiKhoan findByCccdCmtAndMatKhau(String cccd, String password);
}
