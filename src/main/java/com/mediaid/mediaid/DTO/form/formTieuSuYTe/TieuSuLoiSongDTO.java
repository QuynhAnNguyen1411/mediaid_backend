package com.mediaid.mediaid.DTO.form.formTieuSuYTe;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TieuSuLoiSongDTO {
    private String loiSongNguoiBenhID;
    @NotNull
    private String accountID;
    private String soKhamID;
    private Integer moiTruongID;
    private List<Integer> thoiQuenLoiSongs;
    private String ghiChu;

    public TieuSuLoiSongDTO(String loiSongNguoiBenhID,String accountID, String soKhamID, Integer moiTruongID, String ghiChu) {
        this.loiSongNguoiBenhID = loiSongNguoiBenhID;
        this.accountID = accountID;
        this.soKhamID = soKhamID;
        this.moiTruongID = moiTruongID;
        this.ghiChu = ghiChu;
    }
}
