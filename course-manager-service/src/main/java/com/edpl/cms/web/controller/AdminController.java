package com.edpl.cms.web.controller;

import com.edpl.cms.service.AdminService;
import com.edpl.cms.web.dto.CourseDto;
import com.edpl.cms.web.dto.CourseInfoDto;
import com.edpl.cms.web.dto.UserDto;
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
    public ResponseEntity<List<CourseInfoDto>> getAllCourses() {
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

    // Удаление курса у пользователя
    @PatchMapping("/users/{userId}/courses/{coursesId}")
    public ResponseEntity<UserDto> deleteCourseFromUser(@PathVariable Long userId, @PathVariable Long coursesId) {
        UserDto user = adminService.deleteCourseFromUser(userId, coursesId);
        return ResponseEntity.ok(user);
    }
}
