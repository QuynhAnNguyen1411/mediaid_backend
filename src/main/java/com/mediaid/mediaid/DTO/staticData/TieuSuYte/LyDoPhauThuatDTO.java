package com.mediaid.mediaid.DTO.staticData.TieuSuYte;

import com.mediaid.mediaid.DTO.staticData.DTOMapper;
import com.mediaid.mediaid.DTO.staticData.TemplateDuLieuTinhDTO;
import com.mediaid.mediaid.model.LyDoPhauThuat;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LyDoPhauThuatDTO extends TemplateDuLieuTinhDTO implements DTOMapper<LyDoPhauThuat, LyDoPhauThuatDTO> {
    public LyDoPhauThuatDTO(int ID, String ten) {
        super(ID, ten);
    }

    @Override
    public LyDoPhauThuatDTO map(LyDoPhauThuat entity) {
        return new LyDoPhauThuatDTO(entity.getLyDoPhauThuatID(), entity.getLyDo());
    }
}
