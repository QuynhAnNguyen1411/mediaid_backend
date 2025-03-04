package com.mediaid.mediaid.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.Id;

public class PatientInformation {
    // Patient
    @Id
    private String personalIdentifier;
    private String healthInsurance;
    private String patientName;
    private String addressPatient;
    private String phoneNumber;
    private String emailPatient;
    private String dob;
    private String sexPatient;

    // Patient's family member
    private String patientFamilyName;
    private String patientRelationship;
    private String patientFamilyIdentifier;
    private String patientFamilyPhoneNumber;

    public String getPersonalIdentifier() {
        return personalIdentifier;
    }

    public void setPersonalIdentifier(String personalIdentifier) {
        this.personalIdentifier = personalIdentifier;
    }

    public String getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(String healthInsurance) {
        this.healthInsurance = healthInsurance;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getAddressPatient() {
        return addressPatient;
    }

    public void setAddressPatient(String addressPatient) {
        this.addressPatient = addressPatient;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailPatient() {
        return emailPatient;
    }

    public void setEmailPatient(String emailPatient) {
        this.emailPatient = emailPatient;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSexPatient() {
        return sexPatient;
    }

    public void setSexPatient(String sexPatient) {
        this.sexPatient = sexPatient;
    }

    public String getPatientFamilyName() {
        return patientFamilyName;
    }

    public void setPatientFamilyName(String patientFamilyName) {
        this.patientFamilyName = patientFamilyName;
    }

    public String getPatientRelationship() {
        return patientRelationship;
    }

    public void setPatientRelationship(String patientRelationship) {
        this.patientRelationship = patientRelationship;
    }

    public String getPatientFamilyIdentifier() {
        return patientFamilyIdentifier;
    }

    public void setPatientFamilyIdentifier(String patientFamilyIdentifier) {
        this.patientFamilyIdentifier = patientFamilyIdentifier;
    }

    public String getPatientFamilyPhoneNumber() {
        return patientFamilyPhoneNumber;
    }

    public void setPatientFamilyPhoneNumber(String patientFamilyPhoneNumber) {
        this.patientFamilyPhoneNumber = patientFamilyPhoneNumber;
    }
}
