package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<TaiKhoan, String> {
    TaiKhoan findByCccdCmtAndMatKhau(String cccd, String password);
    TaiKhoan findByCccdCmt(String cccd);
    TaiKhoan findBySdt(String sdt);

    TaiKhoan findByAccountID(String accountID);

    @Query(nativeQuery = true, value = "select a.* from mediate_db.tai_khoan a " +
            "inner join mediate_db.bac_si b on a.accountid = b.accountid ")
    List<TaiKhoan> findAccountBacSi();
}
