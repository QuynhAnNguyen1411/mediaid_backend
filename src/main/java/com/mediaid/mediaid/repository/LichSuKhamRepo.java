package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.DTO.lichSuKham.LichSuKhamDTO;
import com.mediaid.mediaid.model.LichSuKham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LichSuKhamRepo extends JpaRepository<LichSuKham, String> {
    @Query("SELECT new com.mediaid.mediaid.DTO.lichSuKham.LichSuKhamDTO(" +
            "a.lichSuKhamID, a.ketLuan, c.trangThai, a.ngayKham, d.ten, f.ten) " +
            "FROM LichSuKham a " +
            "inner join a.soKham b " +
            "inner join a.trangThaiKham c " +
            "inner join a.coSoBenhVien d " +
            "left join a.bacSi e " +
            "left join e.taiKhoan f " +
            "where a.soKham.soKhamID = ?1 " +
            "order by a.ngayKham desc ")
    List<LichSuKhamDTO> findBySoKhamID(String soKhamID);
}
