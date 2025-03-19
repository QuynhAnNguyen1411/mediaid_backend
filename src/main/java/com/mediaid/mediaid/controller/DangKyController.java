package com.mediaid.mediaid.controller;

import com.mediaid.mediaid.DTO.form.formDangKy.FormDangKy;
import com.mediaid.mediaid.service.abstracts.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentication")
public class DangKyController {
    @Autowired
    AuthenticationService authenticationService;
    @PostMapping("/registry")
    public ResponseEntity<?> registry(@RequestBody @Valid FormDangKy registryForm, BindingResult bindingResult) {
        return authenticationService.registry(registryForm, bindingResult);
    }
}
