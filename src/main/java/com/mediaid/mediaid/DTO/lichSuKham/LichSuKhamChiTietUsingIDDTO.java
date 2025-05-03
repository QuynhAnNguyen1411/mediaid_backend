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
public class LichSuKhamChiTietUsingIDDTO {
    private String lich_su_kham_chi_tietid;
    private String ten_loai;
    private LocalDateTime ngay_kham;
    private String ma_phong_kham;
    private String ten;
    private String ghi_chu;
    private String anh_ket_qua;
    private Double gia;
}
