package com.edpl.cms.web.controller.owner;

import com.edpl.cms.service.LectureService;
import com.edpl.cms.web.dto.LectureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/courses/lectures")
@RequiredArgsConstructor
@RolesAllowed({"owner"})
public class LectureController {
    private final LectureService service;

    @GetMapping("/{id}")
    public LectureDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/module/{id}")
    public List<LectureDto> getAllByModuleId(@PathVariable Long id) {
        return service.getAllByModuleId(id);
    }

    @PostMapping
    public LectureDto save(@RequestBody LectureDto dto) {
        return service.save(dto);
    }

    @PatchMapping
    public LectureDto update(@RequestBody LectureDto dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
         service.deleteById(id);
    }
}
