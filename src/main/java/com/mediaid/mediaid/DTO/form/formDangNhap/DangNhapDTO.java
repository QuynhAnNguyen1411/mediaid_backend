package com.mediaid.mediaid.DTO.form.formDangNhap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DangNhapDTO {
    @NotNull
    @NotEmpty
    @JsonProperty("personalIdentifier")
    private String cmt;
    @NotNull
    @NotEmpty
    @JsonProperty("password")
    private String password;
}
