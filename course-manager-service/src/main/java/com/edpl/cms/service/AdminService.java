package com.edpl.cms.service;

import com.edpl.cms.web.dto.CourseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {
    private final CourseService courseService;
    private final LectureService lectureService;
    private final ModuleService moduleService;

    @Transactional(readOnly = true)
    public List<CourseDto> getAllCourses() {
        return courseService.findAll();
    }

    @Transactional
    public void deleteCourseById(Long id) {
        courseService.deleteById(id);
    }

    @Transactional
    public void deleteLectureById(Long id) {
        lectureService.deleteById(id);
    }

    @Transactional
    public void deleteModuleById(Long id) {
        moduleService.deleteById(id);
    }
}
