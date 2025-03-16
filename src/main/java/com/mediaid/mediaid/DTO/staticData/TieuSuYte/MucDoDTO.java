package com.mediaid.mediaid.DTO.staticData.TieuSuYte;

import com.mediaid.mediaid.DTO.staticData.DTOMapper;
import com.mediaid.mediaid.DTO.staticData.TemplateDuLieuTinhDTO;
import com.mediaid.mediaid.model.MucDo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MucDoDTO extends TemplateDuLieuTinhDTO implements DTOMapper<MucDo, MucDoDTO> {
    public MucDoDTO(int ID, String ten) {
        super(ID, ten);
    }

    @Override
    public MucDoDTO map(MucDo entity) {
        return new MucDoDTO(entity.getMucDoID(), entity.getMucDo());
    }
}
