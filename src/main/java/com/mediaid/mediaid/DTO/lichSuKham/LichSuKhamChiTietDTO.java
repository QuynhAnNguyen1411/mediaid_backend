package com.mediaid.mediaid.DTO.lichSuKham;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LichSuKhamChiTietDTO {
    private String lich_su_kham_chi_tietid;
    private String loai_dich_vu;
    private String ten_loai;
    private LocalDateTime ngay_kham;
    private String ma_phong_kham;
    private String ghi_chu;
    private String ten_co_so_kham;
    private String anh_ket_qua;
    private Double gia;
    private int soThuTu;

    public LichSuKhamChiTietDTO(String lich_su_kham_chi_tietid, String loai_dich_vu, String ten_loai,
                                LocalDateTime ngay_kham, String ma_phong_kham, String ghi_chu, String ten_co_so_kham,
                                Double gia, int soThuTu) {
        this.lich_su_kham_chi_tietid = lich_su_kham_chi_tietid;
        this.loai_dich_vu = loai_dich_vu;
        this.ten_loai = ten_loai;
        this.ngay_kham = ngay_kham;
        this.ma_phong_kham = ma_phong_kham;
        this.ghi_chu = ghi_chu;
        this.ten_co_so_kham = ten_co_so_kham;
        this.soThuTu = soThuTu;
        this.gia = gia;
    }
}
