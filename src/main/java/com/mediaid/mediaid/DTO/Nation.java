package com.mediaid.mediaid.DTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Nation {
    @JsonProperty("nationID")
    private int nationID;
    @JsonProperty("nationName")
    private String nationName;

    public Nation(int nationID, String nationName) {
        this.nationID = nationID;
        this.nationName = nationName;
    }
}
