package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.DTO.staticData.GetMappingData.SoKhamDTO;
import com.mediaid.mediaid.model.SoKham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SoKhamRepo extends JpaRepository<SoKham, String> {
    SoKham findBySoKhamID(String id);
    @Query("SELECT new com.mediaid.mediaid.DTO.staticData.GetMappingData.SoKhamDTO(a.accountid, a.ten, a.cccd_cmt, b.bhyt, a.sdt) FROM account a inner join  so_kham b on a.accountid = b.accountid  where a.accountid = ?1")
    SoKhamDTO findByAccountID(String accounID);


//    private String accountID;
//    private String accountName;
//    private String cmndCmt;
//    private String bhyt;
//    private String sdt;
}
