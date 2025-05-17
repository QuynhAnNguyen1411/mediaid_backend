package com.mediaid.mediaid.DTO.staticData.GetMappingData;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SoKhamDTO {
    @NotNull
    @NotEmpty
    @JsonProperty("examinationBookID")
    private String soKhamID;
    @NotNull
    @NotEmpty
    @JsonProperty("patientName")
    private String accountName;
    @NotNull
    @NotEmpty
    @JsonProperty("personalIdentifier")
    private String cmndCmt;
    @JsonProperty("healthInsurance")
    private String bhyt;
    @JsonProperty("addressPatient")
    private String diaChi;
    @NotNull
    @NotEmpty
    @JsonProperty("phoneNumber")
    private String sdt;
    @JsonProperty("emailPatient")
    private String email;
    @NotNull
    @JsonProperty("dob")
    private Date ngaySinh;
    @JsonProperty("sexPatient")
    private int gioiTinhID;
    @JsonProperty("nationPatient")
    private int danTocID;
    @NotNull
    @NotEmpty
    @JsonProperty("patientFamilyName")
    private String tenNguoiGiamHo;
    @NotNull
    @NotEmpty
    @JsonProperty("patientFamilyIdentifier")
    private String cccdCmtNguoiGiamHo;
    @NotNull
    @NotEmpty
    @JsonProperty("patientRelationship")
    private String moiQuanHe;
    @NotNull
    @NotEmpty
    @JsonProperty("patientFamilyPhoneNumber")
    private String sdtNguoiGiamHo;
}
