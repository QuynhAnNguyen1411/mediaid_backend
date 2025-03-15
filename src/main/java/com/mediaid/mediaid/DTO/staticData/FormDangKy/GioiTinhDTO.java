package com.mediaid.mediaid.DTO.staticData.FormDangKy;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class GioiTinhDTO {
    public GioiTinhDTO(int genderID, String genderName) {
        this.genderID = genderID;
        this.genderName = genderName;
    }

    @JsonProperty("genderID")
    private int genderID;
    @JsonProperty("genderName")
    private String genderName;

    public static GioiTinhDTO mapGioiTinhDTO(GioiTinh gioiTinh) {
        return new GioiTinhDTO(gioiTinh.getGioiTinhID(), gioiTinh.getTitle());
    }
    public static List<GioiTinhDTO> gioiTinhDTOList (List<GioiTinh> gioiTinhs) {
        List<GioiTinhDTO> gioiTinhDTOS = new ArrayList<>();
        gioiTinhs.forEach(g -> gioiTinhDTOS.add(mapGioiTinhDTO(g)));
        return gioiTinhDTOS;
    }
}