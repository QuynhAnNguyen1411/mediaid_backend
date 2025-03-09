package com.mediaid.mediaid.service.abtract;

import com.mediaid.mediaid.DTO.form.RegistryForm;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface RegistryService {
    ResponseEntity<?> registry(RegistryForm registryForm, BindingResult bindingResult);
}
