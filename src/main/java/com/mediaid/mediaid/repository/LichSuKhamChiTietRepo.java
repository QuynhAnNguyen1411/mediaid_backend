package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.DTO.lichSuKham.LichSuKhamChiTietDTO;
import com.mediaid.mediaid.DTO.lichSuKham.LichSuKhamChiTietUsingIDDTO;
import com.mediaid.mediaid.model.LichSuKhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LichSuKhamChiTietRepo extends JpaRepository<LichSuKhamChiTiet, String> {
    @Query("SELECT new com.mediaid.mediaid.DTO.lichSuKham.LichSuKhamChiTietDTO(" +
            "a.lichSuKhamChiTietID, f.loaiDichVu, d.tenLoai, a.ngayKham, b.maPhongKham, a.ghiChu, e.ten) " +
            "FROM LichSuKhamChiTiet a " +
            "inner join a.phongKhamChiTiet b " +
            "inner join b.phongKham c " +
            "inner join c.dichVuKham d " +
            "inner join d.mauLoaiKham f " +
            "inner join b.coSoBenhVien e " +
            "where a.lichSuKham.lichSuKhamID = ?1 " +
            "order by a.ngayKham desc ")
    List<LichSuKhamChiTietDTO> findByLichSuKhamID(String lichSuKhamID);

    @Query("SELECT new com.mediaid.mediaid.DTO.lichSuKham.LichSuKhamChiTietUsingIDDTO(" +
            "a.lichSuKhamChiTietID, d.tenLoai, a.ngayKham, b.maPhongKham, e.ten, a.ghiChu, a.anhKetQua, a.gia) " +
            "from LichSuKhamChiTiet a " +
            "inner join a.phongKhamChiTiet b " +
            "inner join b.phongKham c " +
            "inner join c.dichVuKham d " +
            "inner join b.coSoBenhVien e " +
            "where a.lichSuKhamChiTietID = ?1 ")
    LichSuKhamChiTietUsingIDDTO findByLichSuKhamChiTietID(String lichSuKhamChiTietID);
}
