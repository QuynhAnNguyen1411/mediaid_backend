package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.DTO.lichSuKham.LichSuSuDungThuocDTO;
import com.mediaid.mediaid.model.LichSuSuDungThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LichSuSuDungThuocRepo extends JpaRepository<LichSuSuDungThuoc, String> {
    @Query("SELECT new com.mediaid.mediaid.DTO.lichSuKham.LichSuSuDungThuocDTO(" +
            "a.lichSuKhamChiTietID, a.tenThuoc, a.huongDanSuDung, a.lieuLuong, a.donVi, b.lichSuKhamID) " +
            "from LichSuSuDungThuoc a " +
            "inner join a.lichSuKham b " +
            "where b.lichSuKhamID = ?1 ")
    List<LichSuSuDungThuocDTO> findByLichSuKhamID(String lichSuKhamID);
}
