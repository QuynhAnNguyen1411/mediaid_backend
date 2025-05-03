package com.mediaid.mediaid.DTO.lichSuKham;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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
    private List<LichSuKhamChiTietDTO> lichSuKhamChiTietDTOS;
    private List<LichSuSuDungThuocDTO> lichSuSuDungThuocDTOList;

    public LichSuKhamDTO(String lich_su_khamid, String ket_luan, String trang_thai, LocalDateTime ngay_kham, String coSo, String tenBacSi) {
        this.lich_su_khamid = lich_su_khamid;
        this.ket_luan = ket_luan;
        this.trang_thai = trang_thai;
        this.ngay_kham = ngay_kham;
        this.coSo = coSo;
        this.tenBacSi = tenBacSi;
    }
}
