package com.edpl.cms.web.controller;

import com.edpl.cms.service.CourseService;
import com.edpl.cms.web.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
	private final CourseService courseService;

	@GetMapping
	public ResponseEntity<List<CourseDto>> getAllCourses() {
		List<CourseDto> courseEntities = courseService.findAll();

		return ResponseEntity.ok(courseEntities);
	}

	@GetMapping("/{courseId}")
	public ResponseEntity<CourseDto> getCourseById(@PathVariable Long courseId) {
		CourseDto courseDto = courseService.findById(courseId);

		return ResponseEntity.ok(courseDto);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody CourseDto courseDto) {
		CourseDto dto = courseService.save(courseDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
}
