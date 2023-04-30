package com.edpl.cms.web.controller;

import com.edpl.cms.service.StudentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@SecurityRequirement(name = "basic-auth")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/courses/{courseId}/sign-up")
    public ResponseEntity<?> signUpForCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(studentService.signUpForCourse(courseId));
    }

    @GetMapping("/courses/{courseId}/sign-out")
    public ResponseEntity<?> singOutForCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(studentService.signOutForCourse(courseId));
    }

    @GetMapping("/courses")
    public ResponseEntity<?> getAllStudentCourses() {
        return ResponseEntity.ok(studentService.getAllUserCourses());
    }
}
