package com.edpl.cms.web.controller;

import com.edpl.cms.service.TestService;
import com.edpl.cms.web.dto.TestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tests")
@RequiredArgsConstructor
public class TestController {
    private final TestService service;

    @GetMapping("/{id}")
    public TestDto getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
