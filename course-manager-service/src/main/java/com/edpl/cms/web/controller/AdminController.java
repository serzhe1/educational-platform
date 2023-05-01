package com.edpl.cms.web.controller;

import com.edpl.cms.service.AdminService;
import com.edpl.cms.web.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/courses")
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        return ResponseEntity.ok(adminService.getAllCourses());
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long id) {
        adminService.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/lectures/{id}")
    public ResponseEntity<Void> deleteLectureById(@PathVariable Long id) {
        adminService.deleteLectureById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/modules/{id}")
    public ResponseEntity<Void> deleteModuleById(@PathVariable Long id) {
        adminService.deleteModuleById(id);
        return ResponseEntity.noContent().build();
    }
}
