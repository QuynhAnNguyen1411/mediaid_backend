package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.DTO.lichSuKham.LichSuKhamChiTietDTO;
import com.mediaid.mediaid.model.LichSuKhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface LichSuKhamChiTietRepo extends JpaRepository<LichSuKhamChiTiet, String> {
    @Query("SELECT new com.mediaid.mediaid.DTO.lichSuKham.LichSuKhamChiTietDTO(" +
            "a.lichSuKhamChiTietID, f.loaiDichVu, c.phongKham, a.ngayKham, b.maPhongKham, a.ghiChu, e.ten, a.gia, a.soKhamThuTu) " +
            "FROM LichSuKhamChiTiet a " +
            "inner join a.phongKhamChiTiet b " +
            "inner join b.phongKham c " +
            "inner join c.dichVuKham d " +
            "inner join d.mauLoaiKham f " +
            "inner join b.coSoBenhVien e " +
            "where a.lichSuKham.lichSuKhamID = ?1 " +
            "order by a.ngayKham asc ")
    List<LichSuKhamChiTietDTO> findByLichSuKhamID(String lichSuKhamID);

    @Query("SELECT new com.mediaid.mediaid.DTO.lichSuKham.LichSuKhamChiTietDTO(" +
            "a.lichSuKhamChiTietID, f.loaiDichVu, c.phongKham, a.ngayKham, b.maPhongKham, a.ghiChu, e.ten, a.anhKetQua, a.gia, a.soKhamThuTu) " +
            "from LichSuKhamChiTiet a " +
            "inner join a.phongKhamChiTiet b " +
            "inner join b.phongKham c " +
            "inner join c.dichVuKham d " +
            "inner join d.mauLoaiKham f " +
            "inner join b.coSoBenhVien e " +
            "where a.lichSuKhamChiTietID = ?1 ")
    LichSuKhamChiTietDTO findByLichSuKhamChiTietID(String lichSuKhamChiTietID);

    @Query(nativeQuery = true, value = "select a.* from mediate_db.lich_su_kham_chi_tiet a " +
            "inner join mediate_db.lich_su_kham b on a.lich_su_khamid = b.lich_su_khamid " +
            "inner join mediate_db.phong_kham_chi_tiet c on a.phong_kham_chi_tietid = c.phong_kham_chi_tietid " +
            "where b.so_khamid= ?1 AND c.phong_khamid = ?2 AND DATE(a.ngay_kham) = ?3;")
    List<LichSuKhamChiTiet> checkIfUserHaveNumberAtThisRoom(String soKhamID, String phongKhamID, LocalDate date);

    @Query(nativeQuery = true, value = "select count(b.lich_su_khamid) from mediate_db.lich_su_kham_chi_tiet a " +
            "inner join mediate_db.lich_su_kham b on a.lich_su_khamid = b.lich_su_khamid " +
            "where b.so_khamid= ?1 AND DATE(a.ngay_kham) = ?2 AND b.trang_thai_khamid = ?3;")
    Integer checkNumberOfLichSuKhamDangChoOnCurrentDay(String soKhamID, LocalDate date, int trangThaiKhamID);
}
