package com.edpl.cms.web.controller;

import com.edpl.cms.service.ModuleService;
import com.edpl.cms.web.dto.ModuleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/courses/modules")
@RequiredArgsConstructor
@RolesAllowed({"owner"})
public class ModuleController {
    private final ModuleService service;

    @PostMapping
    public ModuleDto save(@RequestBody ModuleDto dto) {
        return service.save(dto);
    }

    @PatchMapping
    public ModuleDto update(@RequestBody ModuleDto dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
       service.deleteById(id);
    }
}
