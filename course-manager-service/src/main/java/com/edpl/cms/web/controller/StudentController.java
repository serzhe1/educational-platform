package com.edpl.cms.web.controller;

import com.edpl.cms.service.StudentService;
import com.edpl.cms.web.dto.AnswerRequest;
import com.edpl.cms.web.dto.TestDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@SecurityRequirement(name = "basic-auth")
public class StudentController {
    private final StudentService studentService;

//    @GetMapping("/courses/{courseId}/sign-up")
//    public ResponseEntity<?> signUpForCourse(@PathVariable Long courseId) {
//        return ResponseEntity.ok(studentService.signUpForCourse(courseId));
//    }
//
//    @GetMapping("/courses/{courseId}/sign-out")
//    public ResponseEntity<?> singOutForCourse(@PathVariable Long courseId) {
//        return ResponseEntity.ok(studentService.signOutForCourse(courseId));
//    }
//
//    @GetMapping("/courses")
//    public ResponseEntity<?> getAllStudentCourses() {
//        return ResponseEntity.ok(studentService.getAllUserCourses());
//    }
//
//    @GetMapping("/courses/{courseId}")
//    public ResponseEntity<?> getCourseById(@PathVariable Long courseId) {
//        return ResponseEntity.ok(studentService.getCourseById(courseId));
//    }
//
//    @GetMapping("/courses/modules/lectures/{lectureId}")
//    public ResponseEntity<?> getLectureById(@PathVariable Long lectureId) {
//        return ResponseEntity.ok(studentService.getLectureById(lectureId));
//    }
//
//    @GetMapping("/courses/modules/{moduleId}/tests")
//    public ResponseEntity<?> getAllTestsByModules(@PathVariable Long moduleId) {
//        return ResponseEntity.ok(studentService.getAllTestByModuleId(moduleId));
//    }
//
//    @PostMapping("courses/modules/tests")
//    public ResponseEntity<?> setAnswerTest(@RequestBody AnswerRequest request) {
//        return ResponseEntity.ok(studentService.setAnswerTest(request));
//    }
}
