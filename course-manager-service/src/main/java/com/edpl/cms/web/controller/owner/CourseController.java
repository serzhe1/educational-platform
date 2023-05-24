package com.edpl.cms.web.controller.owner;

import com.edpl.cms.service.CourseService;
import com.edpl.cms.web.dto.CourseDto;
import com.edpl.cms.web.dto.CourseInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseInfoDto>> findAll(@RequestParam Optional<String> namePattern) {
        List<CourseInfoDto> resultDtos;

        if (namePattern.isPresent()) {
            resultDtos = courseService.findAllByName(namePattern.get());
        } else {
            resultDtos = courseService.findAll();
        }

        return ResponseEntity.ok().body(resultDtos);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long courseId) {
        CourseDto courseDto = courseService.findById(courseId);

        return ResponseEntity.ok(courseDto);
    }

    @PostMapping("/owner")
    @RolesAllowed({"owner"})
    public ResponseEntity<?> save(@RequestBody CourseDto courseDto) {
        CourseDto dto = courseService.save(courseDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PatchMapping("/owner")
    @RolesAllowed({"owner"})
    public ResponseEntity<CourseDto> partialUpdate(@RequestBody CourseDto courseDto) {
        CourseDto dto = courseService.update(courseDto);

        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/owner")
    @RolesAllowed({"owner"})
    public ResponseEntity<CourseDto> fullUpdate(@RequestBody CourseDto courseDto) {
        CourseDto dto = courseService.update(courseDto);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("owner/{id}")
    @RolesAllowed({"owner"})
    public ResponseEntity<?> delete(@PathVariable("id") Long courseId) {
        courseService.deleteById(courseId);

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/owner/my")
    @RolesAllowed({"owner"})
    public ResponseEntity<List<CourseInfoDto>> getAllMyCourses() {
        return ResponseEntity.ok().body(courseService.getAllMyCourses());
    }
}
