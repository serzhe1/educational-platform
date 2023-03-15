package com.edpl.coursemanagerservice.web.controller;

import com.edpl.coursemanagerservice.persistent.model.HealthEntity;
import com.edpl.coursemanagerservice.persistent.service.HealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/health")
@RequiredArgsConstructor
public class HealthController {
    private final HealthService service;
    @GetMapping("/")
    public ResponseEntity<List<HealthEntity>> health () {
        return ResponseEntity.ok(service.getAll());
    }
}
