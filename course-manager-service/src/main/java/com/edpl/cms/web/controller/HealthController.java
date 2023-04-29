package com.edpl.cms.web.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@RequiredArgsConstructor
@SecurityRequirement(name = "basic-auth")
public class HealthController {

    @GetMapping
    public ResponseEntity<String> health () {
        return ResponseEntity.ok("ALIVE");
    }
}
