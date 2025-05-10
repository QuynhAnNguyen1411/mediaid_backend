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
    @JsonProperty("drugsID")
    private String tieuSuThuocID;
    @NotNull
    @NotEmpty
    @JsonProperty("accountID")
    private String accountID;
    @JsonProperty("soKhamID")
    private String soKhamID;
    @NotNull
    @JsonProperty("usageStatusDrugs")
    private Integer tinhTrangSuDungID;
    @NotNull
    @JsonProperty("drugsType")
    private Integer loaiSanPhamID;
    @NotNull
    @NotEmpty
    @JsonProperty("drugsName")
    private String tenThuoc;
    @JsonProperty("startDrugs")
    private String batDau;

    @JsonProperty("endDrugs")
    private String ketThuc;
    @JsonProperty("noteDrugs")
    private String ghiChu;
}
