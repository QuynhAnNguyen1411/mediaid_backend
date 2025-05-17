package com.mediaid.mediaid.DTO.staticData.GetMappingData;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    @NotEmpty
    private String soKhamID;
    @NotNull
    @NotEmpty
    private String accountName;
    @NotNull
    @NotEmpty
    private String cmndCmt;
    private String bhyt;
    private String diaChi;
    @NotNull
    @NotEmpty
    private String sdt;
    private String email;
    @NotNull
    @NotEmpty
    private Date ngaySinh;
    private int gioiTinhID;
    private int danTocID;
    @NotNull
    @NotEmpty
    private String tenNguoiGiamHo;
    @NotNull
    @NotEmpty
    private String cccdCmtNguoiGiamHo;
    @NotNull
    @NotEmpty
    private String moiQuanHe;
    @NotNull
    @NotEmpty
    private String sdtNguoiGiamHo;
}
