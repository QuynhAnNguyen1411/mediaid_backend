package com.mediaid.mediaid.controller;

import com.mediaid.mediaid.model.PatientInformation;
import com.mediaid.mediaid.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    // Lấy thông tin bệnh nhân
    @GetMapping("/{id}")
    public PatientInformation getPatient(@PathVariable String personalIdentifier) {
        Optional<PatientInformation> patient = patientRepository.findById(personalIdentifier);
        return patient.orElse(null);
    }

    // Cập nhật thông tin bệnh nhân
    @PutMapping("/{personalIdentifier}")
    public PatientInformation updatePatient(@PathVariable String personalIdentifier, @RequestBody PatientInformation patientInfo) {
        Optional<PatientInformation> existingPatient = patientRepository.findById(personalIdentifier);
        if (existingPatient.isPresent()) {
            PatientInformation patient = existingPatient.get();
            patient.setPatientName(patientInfo.getPatientName());
            patient.setPhoneNumber(patientInfo.getPhoneNumber());
            patient.setEmailPatient(patientInfo.getEmailPatient());
            patient.setAddressPatient(patientInfo.getAddressPatient());
            patient.setHealthInsurance(patientInfo.getHealthInsurance());
            patient.setSexPatient(patientInfo.getSexPatient());
            return patientRepository.save(patient);
        } else {
            return null;  // Trả về null nếu không tìm thấy bệnh nhân
        }
    }
}
