package com.edpl.cms.service;

import com.edpl.cms.web.dto.CourseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {
    private final CourseService courseService;
    private final LectureService lectureService;
    private final ModuleService moduleService;

    public List<CourseDto> getAllCourses() {
        return courseService.findAll();
    }

    public void deleteCourseById(Long id) {
        courseService.deleteById(id);
    }

    public void deleteLectureById(Long id) {
        lectureService.deleteById(id);
    }

    public void deleteModuleById(Long id) {
        moduleService.deleteById(id);
    }
}
