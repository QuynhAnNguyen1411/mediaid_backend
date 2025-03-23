package com.mediaid.mediaid.DTO.form.formDangNhap;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DangNhapDTO {
    @NotNull
    @NotEmpty
    private String cmt;
    @NotNull
    @NotEmpty
    private String password;
}
