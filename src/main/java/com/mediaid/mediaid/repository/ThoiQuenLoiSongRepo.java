package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.ThoiQuenLoiSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThoiQuenLoiSongRepo extends JpaRepository<ThoiQuenLoiSong, String> {
//    ThoiQuenLoiSong findByThoiQuenLoiSongID(String id);
    @Query(nativeQuery = true, value = "select * from thoi_quen_loi_song where loi_song_nguoi_benhid = ?1")
    List<ThoiQuenLoiSong> findByLoiSongNguoiBenhID(String id);
    @Query(nativeQuery = true, value = "SELECT u.thoi_quenid FROM thoi_quen_loi_song u WHERE u.loi_song_nguoi_benhid= ?1 ")
    List<Integer> findIDByLoiSongNguoiBenhIds(String loi_song_nguoi_benhid);
}