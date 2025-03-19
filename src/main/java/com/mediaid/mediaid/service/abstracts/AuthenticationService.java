package com.mediaid.mediaid.service.abstracts;

import com.mediaid.mediaid.DTO.form.formDangKy.FormDangKy;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface AuthenticationService {
    ResponseEntity<?> registry(FormDangKy registryForm, BindingResult bindingResult);
}
