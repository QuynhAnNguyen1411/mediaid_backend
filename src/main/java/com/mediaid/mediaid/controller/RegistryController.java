package com.mediaid.mediaid.controller;

import com.mediaid.mediaid.DTO.form.RegistryForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registry")
public class RegistryController {
//    @Autowired
//    StaticService staticService;
    @PostMapping("/staticDataForRegistry")
    public ResponseEntity<?> registry(@RequestBody @Valid RegistryForm registryForm, BindingResult bindingResult) {
        return null;
    }
}
