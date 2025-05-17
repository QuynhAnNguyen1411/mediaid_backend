package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuLoiSongDTO;
import com.mediaid.mediaid.model.LoiSongNguoiBenh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface LoiSongNguoiBenhRepo extends JpaRepository<LoiSongNguoiBenh, String> {
    @Query("SELECT new com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuLoiSongDTO(" +
            "a.loiSongNguoiBenhID, c.accountID, b.soKhamID, d.moiTruongID, a.ghiChu) " +
            "FROM LoiSongNguoiBenh a inner join a.soKham b " +
            "inner join b.taiKhoan c " +
            "left join a.moiTruong d " +
            "where c.accountID = ?1")
    TieuSuLoiSongDTO findDTOByAccountID(String id);

    @Query("SELECT a " +
            "FROM LoiSongNguoiBenh a inner join a.soKham b inner join b.taiKhoan c " +
            "where c.accountID = ?1")
    LoiSongNguoiBenh findByAccountID(String id);
}
//    private String accountID;
//    private String soKham;
//    private Integer moiTruong;
//    private String ghiChu;
