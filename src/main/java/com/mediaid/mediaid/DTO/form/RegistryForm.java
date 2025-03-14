package com.mediaid.mediaid.DTO.form;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mediaid.mediaid.model.Account;
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
public class RegistryForm {

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
    @JsonProperty("healthInsurance")
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
    @JsonProperty("patientPassword")
    private String matKhau;
    private NguoiGiamHoDTO nguoiGiamHo;

    @Autowired
    private ModelMapper modelMapper;
    public Account convertToEntity(RegistryForm registryForm, GioiTinh gioiTinh, DanToc danToc, String matKhau) {
        modelMapper.typeMap(RegistryForm.class, Account.class)
                .addMappings(mapper -> {
                    mapper.skip(Account::setGioiTinh);
                    mapper.skip(Account::setDanToc);
                    mapper.skip(Account::setMatKhau);
                });
        Account account = modelMapper.map(registryForm, Account.class);
        account.setDanToc(danToc);
        account.setGioiTinh(gioiTinh);
        account.setMatKhau(matKhau);
        return account;
    }
}
