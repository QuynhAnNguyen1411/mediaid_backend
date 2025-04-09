package com.mediaid.mediaid.DTO.staticData.TieuSuYte;

import com.mediaid.mediaid.DTO.staticData.DTOMapper;
import com.mediaid.mediaid.DTO.staticData.TemplateDuLieuTinhDTO;
import com.mediaid.mediaid.model.MoiTruong;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MoiTruongDTO extends TemplateDuLieuTinhDTO implements DTOMapper<MoiTruong, MoiTruongDTO> {
    public MoiTruongDTO(int ID, String ten) {
        super(ID, ten);
    }

    @Override
    public MoiTruongDTO map(MoiTruong entity) {
        return new MoiTruongDTO(entity.getMoiTruongID(), entity.getTen());
    }
}
