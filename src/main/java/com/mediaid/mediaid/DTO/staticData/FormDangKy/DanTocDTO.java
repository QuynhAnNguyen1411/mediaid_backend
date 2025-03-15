package com.mediaid.mediaid.DTO.staticData.FormDangKy;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mediaid.mediaid.model.DanToc;
import com.mediaid.mediaid.model.GioiTinh;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DanTocDTO {
    @JsonProperty("nationID")
    private int nationID;
    @JsonProperty("nationName")
    private String nationName;

    public DanTocDTO(int nationID, String nationName) {
        this.nationID = nationID;
        this.nationName = nationName;
    }
    public static DanTocDTO mapDanTocDTO(DanToc danToc) {
        return new DanTocDTO(danToc.getDanTocID(), danToc.getTitle());
    }
    public static List<DanTocDTO> danTocDTOList (List<DanToc> danTocs) {
        List<DanTocDTO> danTocDTOS = new ArrayList<>();
        danTocs.forEach(g -> danTocDTOS.add(mapDanTocDTO(g)));
        return danTocDTOS;
    }
}
