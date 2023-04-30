package com.edpl.cms.web.controller;

import com.edpl.cms.service.ModuleService;
import com.edpl.cms.web.dto.ModuleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/module")
public class ModuleController {

    private final ModuleService moduleService;

    @GetMapping("/{id}")
    public ResponseEntity<ModuleDto> getModule(@PathVariable Long id) {
        ModuleDto moduleDto =  moduleService.getById(id);

        return ResponseEntity.ok(moduleDto);
    }

    @GetMapping
    public ResponseEntity<List<ModuleDto>> getAllModules() {
        List<ModuleDto> modules = moduleService.getAll();
        return ResponseEntity.ok(modules);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ModuleDto moduleDto) {
        ModuleDto dto = moduleService.save(moduleDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PatchMapping
    public ResponseEntity<ModuleDto> update(@RequestBody ModuleDto moduleDto) {
        ModuleDto dto = moduleService.update(moduleDto);

        return ResponseEntity.ok(moduleDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        moduleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
