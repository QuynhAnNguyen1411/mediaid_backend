package com.mediaid.mediaid.DTO.staticData.TieuSuYte;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mediaid.mediaid.DTO.staticData.TemplateDuLieuTinhDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrangThaiDieuTriDTO extends TemplateDuLieuTinhDTO {
}
