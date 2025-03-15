package com.mediaid.mediaid.DTO.form;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mediaid.mediaid.model.DanToc;
import com.mediaid.mediaid.model.GioiTinh;
import com.mediaid.mediaid.model.TaiKhoan;
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
    @JsonProperty("nationPatient")
    private int danTocID;

    @NotNull
    @JsonProperty("sexPatient")
    private int gioiTinhID;
    @NotEmpty
    @NotNull
    @JsonProperty("patientName")
    private String ten;
    @NotNull
    @JsonProperty("dob")
    private Date ngaySinh;
    @NotEmpty
    @NotNull
    @JsonProperty("personalIdentifier")
    private String cccdCmt;
    @NotEmpty
    @NotNull
    private String bhyt;
    @NotEmpty
    @NotNull
    @JsonProperty("addressPatient")
    private String diaChi;
    @NotEmpty
    @NotNull
    @JsonProperty("phoneNumber")
    private String sdt;
    @JsonProperty("emailPatient")
    private String email;
    @NotEmpty
    @NotNull
    @JsonProperty("patientPassword")
    private String matKhau;
    @NotEmpty
    @NotNull
    @JsonProperty("patientFamilyName")
    private String tenNguoiGiamHo;
    @NotEmpty
    @NotNull
    @JsonProperty("patientFamilyIdentifier")
    private String cccdCmtNguoiGiamHo;
    @NotEmpty
    @NotNull
    @JsonProperty("patientRelationship")
    private String moiQuanHe;
    @NotEmpty
    @NotNull
    @JsonProperty("patientFamilyPhoneNumber")
    private String sdtNguoiGiamHo;


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
