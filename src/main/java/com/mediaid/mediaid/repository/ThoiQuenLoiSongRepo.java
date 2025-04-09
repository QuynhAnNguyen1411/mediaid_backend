package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.ThoiQuenLoiSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThoiQuenLoiSongRepo extends JpaRepository<ThoiQuenLoiSong, String> {
//    ThoiQuenLoiSong findByThoiQuenLoiSongID(String id);

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
