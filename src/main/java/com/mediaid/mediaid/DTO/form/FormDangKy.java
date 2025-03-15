package com.mediaid.mediaid.DTO.form;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mediaid.mediaid.model.TaiKhoan;
import com.mediaid.mediaid.model.DanToc;
import com.mediaid.mediaid.model.GioiTinh;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormDangKy {

    @NotNull
    private int danTocID;

    @NotNull
    private int gioiTinhID;
    @NotEmpty
    @NotNull
    private String ten;
    @NotNull
    private Date ngaySinh;
    @NotEmpty
    @NotNull
    private String cccdCmt;
    private String bhyt;
    @NotEmpty
    @NotNull
    private String diaChi;
    @NotEmpty
    @NotNull
    private String sdt;
    private String email;
    @NotEmpty
    @NotNull
    private String matKhau;
    private NguoiGiamHoDTO nguoiGiamHo;

    @Autowired
    private ModelMapper modelMapper;
    public TaiKhoan convertToEntity(FormDangKy registryForm, GioiTinh gioiTinh, DanToc danToc, String matKhau) {
        modelMapper.typeMap(FormDangKy.class, TaiKhoan.class)
                .addMappings(mapper -> {
                    mapper.skip(TaiKhoan::setGioiTinh);
                    mapper.skip(TaiKhoan::setDanToc);
                    mapper.skip(TaiKhoan::setMatKhau);
                });
        TaiKhoan taiKhoan = modelMapper.map(registryForm, TaiKhoan.class);
        taiKhoan.setDanToc(danToc);
        taiKhoan.setGioiTinh(gioiTinh);
        taiKhoan.setMatKhau(matKhau);
        return taiKhoan;
    }
}
