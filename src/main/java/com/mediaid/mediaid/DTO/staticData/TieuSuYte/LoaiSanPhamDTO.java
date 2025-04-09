package com.mediaid.mediaid.DTO.staticData.TieuSuYte;

import com.mediaid.mediaid.DTO.staticData.DTOMapper;
import com.mediaid.mediaid.DTO.staticData.TemplateDuLieuTinhDTO;
import com.mediaid.mediaid.model.LoaiSanPham;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoaiSanPhamDTO extends TemplateDuLieuTinhDTO implements DTOMapper<LoaiSanPham, LoaiSanPhamDTO> {
    public LoaiSanPhamDTO(int ID, String ten) {
        super(ID, ten);
    }

    @Override
    public LoaiSanPhamDTO map(LoaiSanPham entity) {
        return new LoaiSanPhamDTO(entity.getLoaiSanPhamID(), entity.getLoaiSanPham());
    }
}
