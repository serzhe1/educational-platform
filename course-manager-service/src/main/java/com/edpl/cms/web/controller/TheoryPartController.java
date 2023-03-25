package com.edpl.cms.web.controller;

import com.edpl.cms.persistent.model.impls.TheoryPart;
import com.edpl.cms.persistent.service.impls.TheoryPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theories")
@RequiredArgsConstructor
public class TheoryPartController {
    private final TheoryPartService service;

    @GetMapping
    public List<TheoryPart> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TheoryPart getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public TheoryPart getById(@RequestBody TheoryPart part) {
        return service.save(part);
    }
}
