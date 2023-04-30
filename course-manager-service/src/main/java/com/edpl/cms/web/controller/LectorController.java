package com.edpl.cms.web.controller;

import com.edpl.cms.service.LectureService;
import com.edpl.cms.web.dto.LectureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lecture")
public class LectorController {

    private final LectureService lectureService;

    @GetMapping("/{id}")
    public ResponseEntity<LectureDto> getLecture(@PathVariable Long id) {
        LectureDto lectureDto = lectureService.getById(id);

        return ResponseEntity.ok(lectureDto);
    }

    @GetMapping
    public ResponseEntity<List<LectureDto>> getAllLectures() {
        List<LectureDto> lectures = lectureService.getAll();
        return ResponseEntity.ok(lectures);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody LectureDto lectureDto) {
        LectureDto dto = lectureService.save(lectureDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PatchMapping
    public ResponseEntity<LectureDto> update(@RequestBody LectureDto lectureDto) {
        LectureDto dto = lectureService.update(lectureDto);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        lectureService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


