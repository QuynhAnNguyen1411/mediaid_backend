package com.mediaid.mediaid.DTO.form;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mediaid.mediaid.model.NguoiGiamHo;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NguoiGiamHoDTO {
    @NotEmpty
    @NotNull
    private String ten;
    @NotEmpty
    @NotNull
    private String cccdCmt;
    @NotEmpty
    @NotNull
    private String moiQuanHe;
    @NotEmpty
    @NotNull
    private String sdt;

    @Autowired
    private ModelMapper modelMapper;
    public NguoiGiamHo convertToEntity(NguoiGiamHoDTO nguoiGiamHoDTO) {
        modelMapper.typeMap(NguoiGiamHoDTO.class, NguoiGiamHo.class)
                .addMappings(mapper -> {
                    mapper.skip(NguoiGiamHo::setSoKham);
                    mapper.skip(NguoiGiamHo::setGiamHoID);
                });
        NguoiGiamHo nguoiGiamHo = modelMapper.map(nguoiGiamHoDTO, NguoiGiamHo.class);
        return nguoiGiamHo;
    }
}
