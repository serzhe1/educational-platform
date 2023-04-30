package com.edpl.cms.web.controller;

import com.edpl.cms.service.CourseService;
import com.edpl.cms.web.dto.CourseDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
@SecurityRequirement(name = "basic-auth")
public class CourseController {
	private final CourseService courseService;

	@GetMapping
	public ResponseEntity<List<CourseDto>> findAll(@RequestParam Optional<String> namePattern) {
		List<CourseDto> resultDtos;

		if (namePattern.isPresent()) {
			resultDtos =  courseService.findAllByName(namePattern.get());
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

	@PostMapping
	public ResponseEntity<?> save(@RequestBody CourseDto courseDto) {
		CourseDto dto = courseService.save(courseDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}

	@PatchMapping
	public ResponseEntity<CourseDto> partialUpdate(@RequestBody CourseDto courseDto) {
		CourseDto dto = courseService.update(courseDto);

		return ResponseEntity.ok().body(dto);
	}

	@PutMapping
	public ResponseEntity<CourseDto> fullUpdate(@RequestBody CourseDto courseDto) {
		CourseDto dto = courseService.update(courseDto);

		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long courseId) {
		courseService.deleteById(courseId);

		return ResponseEntity.noContent().build();
	}
}
