package com.mediaid.mediaid.controller;

import com.mediaid.mediaid.DTO.form.RegistryForm;
import com.mediaid.mediaid.service.abtract.RegistryService;
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
public class RegistryController {
    @Autowired
    RegistryService registryService;
    @PostMapping("/registry")
    public ResponseEntity<?> registry(@RequestBody @Valid RegistryForm registryForm, BindingResult bindingResult) {
        return registryService.registry(registryForm, bindingResult);
    }
}
