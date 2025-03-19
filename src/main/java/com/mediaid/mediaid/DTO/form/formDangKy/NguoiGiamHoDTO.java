package com.mediaid.mediaid.DTO.form.formDangKy;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mediaid.mediaid.model.NguoiGiamHo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NguoiGiamHoDTO {
    @NotEmpty
    @NotNull
    @JsonProperty("patientFamilyName")
    private String ten;
    @NotEmpty
    @NotNull
    @JsonProperty("patientFamilyIdentifier")
    private String cccdCmt;
    @NotEmpty
    @NotNull
    @JsonProperty("patientRelationship")
    private String moiQuanHe;
    @NotEmpty
    @NotNull
    @JsonProperty("patientFamilyPhoneNumber")
    private String sdt;

    public NguoiGiamHoDTO(String ten, String cccdCmt, String moiQuanHe, String sdt) {
        this.ten = ten;
        this.cccdCmt = cccdCmt;
        this.moiQuanHe = moiQuanHe;
        this.sdt = sdt;
    }

    public NguoiGiamHo convertToEntity(NguoiGiamHoDTO nguoiGiamHoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(NguoiGiamHoDTO.class, NguoiGiamHo.class)
                .addMappings(mapper -> {
                    mapper.skip(NguoiGiamHo::setSoKham);
                    mapper.skip(NguoiGiamHo::setGiamHoID);
                });
        return modelMapper.map(nguoiGiamHoDTO, NguoiGiamHo.class);
    }
}
