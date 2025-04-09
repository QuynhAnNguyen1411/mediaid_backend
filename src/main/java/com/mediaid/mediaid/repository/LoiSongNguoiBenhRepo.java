package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.LoiSongNguoiBenh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoiSongNguoiBenhRepo extends JpaRepository<LoiSongNguoiBenh, String> {
    LoiSongNguoiBenh findByLoiSongNguoiBenhID(String id);
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
