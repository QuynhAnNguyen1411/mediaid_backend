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
}
