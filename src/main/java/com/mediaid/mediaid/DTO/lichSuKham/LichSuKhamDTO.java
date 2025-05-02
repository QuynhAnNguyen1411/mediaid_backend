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
public class LichSuKhamDTO {
    private String lich_su_khamid;
    private String ket_luan;
    private String trang_thai;
    private LocalDateTime ngay_kham;
    private String coSo;
    private String tenBacSi;
}
