package com.mediaid.mediaid.repository;


import com.mediaid.mediaid.model.ThoiQuen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThoiQuenRepo extends JpaRepository<ThoiQuen, Integer> {
//    ThoiQuenLoiSong findByThoiQuenLoiSongID(String id);
    List<ThoiQuen> findByStatus(boolean status);
    @Query("SELECT u FROM ThoiQuen u WHERE u.thoiQuenID IN :ids")
    List<ThoiQuen> findThoiQuenByIds(@Param("ids") List<Integer> ids);
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
