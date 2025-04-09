package com.mediaid.mediaid.DTO.staticData.TieuSuYte;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DuLieuTinhTieuSuYTe {
    private List<LyDoPhauThuatDTO> lyDoPhauThuatDTO;
    private List<PhuongPhapDieuTriDTO> phuongPhapDieuTriDTO;
    private List<MucDoDTO> mucDoDTO;
    private List<LoaiSanPhamDTO> loaiSanPhamDTOS;
    private List<TinhTrangSuDungDTO> tinhTrangSuDungDTOS;

    public DuLieuTinhTieuSuYTe(List<LyDoPhauThuatDTO> lyDoPhauThuatDTO, List<PhuongPhapDieuTriDTO> phuongPhapDieuTriDTO, List<MucDoDTO> mucDoDTO) {
        this.lyDoPhauThuatDTO = lyDoPhauThuatDTO;
        this.phuongPhapDieuTriDTO = phuongPhapDieuTriDTO;
        this.mucDoDTO = mucDoDTO;
    }

    public DuLieuTinhTieuSuYTe(List<LoaiSanPhamDTO> loaiSanPhamDTOS, List<TinhTrangSuDungDTO> tinhTrangSuDungDTOS) {
        this.loaiSanPhamDTOS = loaiSanPhamDTOS;
        this.tinhTrangSuDungDTOS = tinhTrangSuDungDTOS;
    }
}
