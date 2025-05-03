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
public class LichSuKhamUsingIDDTO {
    private String lich_su_khamid;
    private String ket_luan;
    private String trang_thai;
    private LocalDateTime ngay_kham;
    private String coSo;
    private String tenBacSi;
    private List<LichSuKhamChiTietDTO> lichSuKhamChiTietDTOS;
    private List<LichSuSuDungThuocDTO> lichSuSuDungThuocDTOList;
}
