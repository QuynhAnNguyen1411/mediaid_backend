package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuThuocDTO;
import com.mediaid.mediaid.model.TieuSuThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TieuSuThuocRepo extends JpaRepository<TieuSuThuoc, String> {
    TieuSuThuoc findByTieuSuThuocID(String id);
    @Query("SELECT new com.mediaid.mediaid.DTO.form.formTieuSuYTe.TieuSuThuocDTO(" +
            "a.tieuSuThuocID, c.accountID, b.soKhamID, d.tinhTrangSuDungID, e.loaiSanPhamID, a.tenThuoc, a.batDau, a.ketThuc, a.ghiChu) " +
            "FROM TieuSuThuoc a inner join a.soKham b inner join b.taiKhoan c inner join a.tinhTrangSuDung d inner join a.loaiSanPham e " +
            "where c.accountID = ?1")
    List<TieuSuThuocDTO> findPreviewByAccountID(String accounID);
}
//    private String tieuSuThuocID;
//    private String accountID;
//    private String soKhamID;
//    private String tinhTrangSuDungID;
//    private Integer loaiSanPhamID;
//    private String tenThuoc;
//    private String batDau;
//    private String ketThuc;
//    private String ghiChu;