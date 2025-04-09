package com.mediaid.mediaid.DTO.staticData.TieuSuYte;

import com.mediaid.mediaid.DTO.staticData.DTOMapper;
import com.mediaid.mediaid.DTO.staticData.TemplateDuLieuTinhDTO;
import com.mediaid.mediaid.model.TinhTrangSuDung;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TinhTrangSuDungDTO extends TemplateDuLieuTinhDTO implements DTOMapper<TinhTrangSuDung, TinhTrangSuDungDTO> {
    public TinhTrangSuDungDTO(String ID, String ten) {
        super(ID, ten);
    }

    @Override
    public TinhTrangSuDungDTO map(TinhTrangSuDung entity) {
        return new TinhTrangSuDungDTO(entity.getTinhTrangSuDungID(), entity.getTinhTrang());
    }
}
