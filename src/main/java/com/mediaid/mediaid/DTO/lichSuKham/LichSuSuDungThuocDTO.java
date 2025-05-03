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
public class LichSuSuDungThuocDTO {
    private String lich_su_su_dung_thuocid;
    private String ten_thuoc;
    private String huong_dan_su_dung;
    private String lieu_luong;
    private String don_vi;
    private String lich_su_khamid;
}
