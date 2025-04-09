package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.LoaiSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoaiSanPhamRepo extends JpaRepository<LoaiSanPham, Integer> {
    LoaiSanPham findByLoaiSanPhamID(int id);
    List<LoaiSanPham> findByStatus(boolean status);

}
//    private String tieuSuPhauThuatID;
//    private String soKhamID;
//    private int lyDoPhauThuatID;
//    private int mucDoID;
//    private String ten;
//    private String thoiDiemThucHien;
//    private String benhVienThucHien;
//    private String bienChung;
//    private String ghiChu;
