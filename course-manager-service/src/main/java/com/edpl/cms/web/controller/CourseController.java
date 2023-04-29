package com.edpl.cms.web.controller;

import com.edpl.cms.services.CourseService;
import com.edpl.cms.web.dto.CourseDto;
import com.edpl.cms.web.exhandler.AppError;
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

	// TODO нужно как то указывать owner
	@PostMapping
	public ResponseEntity<?> save(@RequestBody CourseDto courseDto) {
		CourseDto dto;
		try {
			dto = courseService.save(courseDto);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new AppError(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}

//	@PatchMapping("/{courseId}")
//	public ResponseEntity<CourseDto> update(@RequestBody CourseDto courseDto) {
//		CourseDto
//	}
}
