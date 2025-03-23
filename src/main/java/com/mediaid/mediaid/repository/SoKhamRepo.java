package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.DTO.staticData.GetMappingData.SoKhamDTO;
import com.mediaid.mediaid.model.SoKham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SoKhamRepo extends JpaRepository<SoKham, String> {
    SoKham findBySoKhamID(String id);
    @Query("SELECT new com.mediaid.mediaid.DTO.staticData.GetMappingData.SoKhamDTO(a.soKhamID, b.ten, b.cccdCmt, a.bhyt, b.sdt) FROM SoKham a inner join a.taiKhoan b where b.accountID = ?1")
    SoKhamDTO findByAccountID(String accounID);


//    private String accountID;
//    private String accountName;
//    private String cmndCmt;
//    private String bhyt;
//    private String sdt;
}
