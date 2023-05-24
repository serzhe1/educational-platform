package com.edpl.cms.web.controller.owner;

import com.edpl.cms.service.TestService;
import com.edpl.cms.web.dto.TestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/courses/tests")
@RequiredArgsConstructor
@RolesAllowed({"owner"})
public class TestController {
    private final TestService service;
    @GetMapping("/{id}")
    public TestDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/module/{id}")
    public List<TestDto> getAllByModuleId(@PathVariable Long id) {
        return service.getAllByModule(id);
    }

    @PostMapping
    public TestDto save(@RequestBody TestDto dto) {
        return service.save(dto);
    }
}
