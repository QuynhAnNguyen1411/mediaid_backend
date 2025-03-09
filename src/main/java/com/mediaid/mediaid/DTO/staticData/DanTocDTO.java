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
public class DanTocDTO {
    @JsonProperty("nationID")
    private int nationID;
    @JsonProperty("nationName")
    private String nationName;

    public DanTocDTO(int nationID, String nationName) {
        this.nationID = nationID;
        this.nationName = nationName;
    }
}
