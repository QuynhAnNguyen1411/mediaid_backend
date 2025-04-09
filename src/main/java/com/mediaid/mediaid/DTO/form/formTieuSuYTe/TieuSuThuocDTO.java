package com.mediaid.mediaid.DTO.form.formTieuSuYTe;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TieuSuThuocDTO {
    @JsonProperty("")
    private String tieuSuThuocID;
    @NotNull
    @NotEmpty
    @JsonProperty("accountID")
    private String accountID;
    @JsonProperty("soKhamID")
    private String soKhamID;
    @NotNull
    @NotEmpty
    private Integer tinhTrangSuDungID;
    @NotNull
    private Integer loaiSanPhamID;
    @NotNull
    @NotEmpty
    private String tenThuoc;
    @NotNull
    @NotEmpty
    private String batDau;
    private String ketThuc;
    private String ghiChu;
}
