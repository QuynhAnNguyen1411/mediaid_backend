package com.mediaid.mediaid.service.abstracts;

import com.mediaid.mediaid.DTO.form.FormDangKy;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface RegistryService {
    ResponseEntity<?> registry(FormDangKy registryForm, BindingResult bindingResult);
}
