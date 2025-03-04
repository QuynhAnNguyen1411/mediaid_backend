package com.mediaid.mediaid.repository;

import com.mediaid.mediaid.model.PatientInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PatientRepository extends JpaRepository<PatientInformation, String> {
    Optional<PatientInformation> findById(String personalIdentifier);
}
