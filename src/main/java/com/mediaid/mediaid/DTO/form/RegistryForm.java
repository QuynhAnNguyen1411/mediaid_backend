package com.mediaid.mediaid.DTO.form;

import com.fasterxml.jackson.annotation.JsonInclude;
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

    @NotEmpty
    @NotNull
    private int danTocID;
    @NotEmpty
    @NotNull
    private int gioiTinhID;
    @NotEmpty
    @NotNull
    private String ten;
    @NotEmpty
    @NotNull
    private Date ngaySinh;
    @NotEmpty
    @NotNull
    private String cccdCmt;
    @NotEmpty
    @NotNull
    private String bhyt;
    @NotEmpty
    @NotNull
    private String diaChi;
    @NotEmpty
    @NotNull
    private String sdt;
    private String email;
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
