package com.mediaid.mediaid.DTO.staticData.GetMappingData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SoKhamDTO {
    private String soKhamID;
    private String accountName;
    private String cmndCmt;
    private String bhyt;
    private String diaChi;
    private String sdt;
    private String email;
    private Date ngaySinh;
    private int gioiTinhID;
    private int danTocID;
    private String tenNguoiGiamHo;
    private String cccdCmtNguoiGiamHo;
    private String moiQuanHe;
    private String sdtNguoiGiamHo;
}
