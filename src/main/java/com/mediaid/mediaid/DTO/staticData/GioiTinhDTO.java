package com.mediaid.mediaid.DTO.staticData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


}
