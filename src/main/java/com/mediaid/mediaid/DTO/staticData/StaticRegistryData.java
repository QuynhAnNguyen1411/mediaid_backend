package com.mediaid.mediaid.DTO.staticData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StaticRegistryData {
    @JsonProperty("gender")
    private List<GioiTinhDTO> gioiTinhDTOS;
    @JsonProperty("nation")
    private List<DanTocDTO> danTocDTOS;
}
