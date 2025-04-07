package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.TinhTrangSuDung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinhTrangSuDungRepo extends JpaRepository<TinhTrangSuDung, String> {
    TinhTrangSuDung findByTinhTrangSuDungID(String id);
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
