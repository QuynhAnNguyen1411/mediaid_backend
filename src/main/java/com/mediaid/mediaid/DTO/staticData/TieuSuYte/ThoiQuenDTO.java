package com.mediaid.mediaid.DTO.staticData.TieuSuYte;

import com.mediaid.mediaid.DTO.staticData.DTOMapper;
import com.mediaid.mediaid.DTO.staticData.TemplateDuLieuTinhDTO;
import com.mediaid.mediaid.model.ThoiQuen;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ThoiQuenDTO extends TemplateDuLieuTinhDTO implements DTOMapper<ThoiQuen, ThoiQuenDTO> {
    public ThoiQuenDTO(long ID, String ten) {
        super(ID, ten);
    }

    @Override
    public ThoiQuenDTO map(ThoiQuen entity) {
        return new ThoiQuenDTO(entity.getThoiQuenID(), entity.getTen());
    }
}
