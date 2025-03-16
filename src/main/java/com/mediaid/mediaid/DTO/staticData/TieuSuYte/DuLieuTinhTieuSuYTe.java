package com.mediaid.mediaid.DTO.staticData.TieuSuYte;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class DuLieuTinhTieuSuYTe {
    private List<LyDoPhauThuatDTO> lyDoPhauThuatDTO;
    private List<PhuongPhapDieuTriDTO> phuongPhapDieuTriDTO;
    private List<MucDoDTO> mucDoDTO;
}
