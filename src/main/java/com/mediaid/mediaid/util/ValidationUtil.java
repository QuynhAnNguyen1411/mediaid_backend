package com.mediaid.mediaid.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.HashMap;

@Component
public class ValidationUtil {
    public static HashMap<String,String> validationCheckBindingResult(BindingResult bindingResult){
        HashMap<String,String> errors = new HashMap<>();
        if (bindingResult.hasErrors()){
            bindingResult.getFieldErrors().forEach(fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return errors;
    }
}
