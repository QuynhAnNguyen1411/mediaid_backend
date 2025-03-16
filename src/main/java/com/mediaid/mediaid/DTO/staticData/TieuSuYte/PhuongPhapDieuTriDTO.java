package com.mediaid.mediaid.DTO.staticData.TieuSuYte;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mediaid.mediaid.DTO.staticData.DTOMapper;
import com.mediaid.mediaid.DTO.staticData.TemplateDuLieuTinhDTO;
import com.mediaid.mediaid.model.PhuongPhapDieuTri;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhuongPhapDieuTriDTO extends TemplateDuLieuTinhDTO implements DTOMapper<PhuongPhapDieuTri, PhuongPhapDieuTriDTO> {
    public PhuongPhapDieuTriDTO(int ID, String ten) {
        super(ID, ten);
    }

    @Override
    public PhuongPhapDieuTriDTO map(PhuongPhapDieuTri entity) {
        return new PhuongPhapDieuTriDTO(entity.getPhuongPhapDieuTriID(), entity.getTen());
    }
}
