package com.mediaid.mediaid.controller;

import com.mediaid.mediaid.DTO.Gender;
import com.mediaid.mediaid.DTO.Nation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class StaticController {
    @GetMapping("/getNation")
    public ResponseEntity<?> getNation() {
        return ResponseEntity.ok(Arrays.asList(
                        new Nation(1, "Kinh"),
                        new Nation(2, "Tày"),
                        new Nation(3, "Thái"),
                        new Nation(4, "Mường"),
                        new Nation(5, "H Mông")
                )
        );
    }

    @GetMapping("/getGender")
    public ResponseEntity<?> getGender() {
        return ResponseEntity.ok(Arrays.asList(
                new Gender(1, "Nam"),
                new Gender(2, "Nữ"),
                new Gender(3, "Khác")
                )
        );
    }
}
