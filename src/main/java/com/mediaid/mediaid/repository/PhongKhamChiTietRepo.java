package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.PhongKhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PhongKhamChiTietRepo extends JpaRepository<PhongKhamChiTiet, String> {

    @Query(nativeQuery = true, value = "select a.* " +
            "from mediate_db.phong_kham_chi_tiet a " +
            "inner join mediate_db.phong_kham b on a.phong_khamid = b.phong_khamid " +
            "inner join mediate_db.chan_doan_bang_phan_vung c on b.phong_khamid = c.phong_khamid " +
            "where c.phan_vungid = ?1 AND a.co_so_benh_vienid = ?2; ")
    List<PhongKhamChiTiet> findbyPhanVungID(String phanVungID, int coSoID);

    @Query(nativeQuery = true, value = "select a.* " +
            "from mediate_db.phong_kham_chi_tiet a " +
            "inner join mediate_db.phong_kham b on a.phong_khamid = b.phong_khamid " +
            "inner join mediate_db.chan_doan_bang_bo_phan c on b.phong_khamid = c.phong_khamid " +
            "where c.bo_phanid = ?1 AND a.co_so_benh_vienid = ?2;")
    List<PhongKhamChiTiet> findbyBoPhanID(String boPhanID, int coSoID);

    @Query(nativeQuery = true, value = "select a.* " +
            "from mediate_db.phong_kham_chi_tiet a " +
            "inner join mediate_db.phong_kham b on a.phong_khamid = b.phong_khamid " +
            "inner join mediate_db.chan_doan_bang_bo_phan c on b.phong_khamid = c.phong_khamid " +
            "where c.bo_phanid = ?1 AND c.phong_kham_ho_tro = ?2 AND a.co_so_benh_vienid = ?3;")
    List<PhongKhamChiTiet> findPhongKhamHoTrobyBoPhanID(String boPhanID, boolean isPhongKhamHoTro, int coSoID);

    @Query(nativeQuery = true, value = "select a.* " +
            "from mediate_db.phong_kham_chi_tiet a " +
            "where a.phong_khamid = ?1 AND a.co_so_benh_vienid = ?2;")
    List<PhongKhamChiTiet> findByphonngKhamID(String phonngKhamID, int coSoID);
}
