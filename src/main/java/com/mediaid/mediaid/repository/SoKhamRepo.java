package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.SoKham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SoKhamRepo extends JpaRepository<SoKham, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM mediate_db.so_kham where accountid = ?1;")
    SoKham findSoKhamByAccountID(String id);

//    @Query("SELECT new com.mediaid.mediaid.DTO.staticData.GetMappingData.SoKhamDTO(a.soKhamID, b.ten, b.cccdCmt, a.bhyt, b.sdt) FROM SoKham a inner join a.taiKhoan b where b.accountID = ?1")
    @Query("SELECT a FROM SoKham a inner join a.taiKhoan b where b.accountID = ?1")
    SoKham findByAccountID(String accounID);

//    private String accountID;
//    private String accountName;
//    private String cmndCmt;
//    private String bhyt;
//    private String sdt;
}
