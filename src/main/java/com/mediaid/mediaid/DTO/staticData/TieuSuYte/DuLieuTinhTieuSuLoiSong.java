package com.mediaid.mediaid.DTO.staticData.TieuSuYte;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DuLieuTinhTieuSuLoiSong {

    private List<ThoiQuenDTO> thoiQuenDTOS;
    private List<MoiTruongDTO> moiTruongDTOS;

    public DuLieuTinhTieuSuLoiSong(List<ThoiQuenDTO> thoiQuenDTOS, List<MoiTruongDTO> moiTruongDTOS) {
        this.thoiQuenDTOS = thoiQuenDTOS;
        this.moiTruongDTOS = moiTruongDTOS;
    }

}
