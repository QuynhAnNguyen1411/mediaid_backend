package com.mediaid.mediaid.DTO.staticData;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhuongPhapDieuTriDTO extends TemplateDuLieuTinhDTO {
}
