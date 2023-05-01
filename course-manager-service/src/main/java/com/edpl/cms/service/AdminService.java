package com.edpl.cms.service;

import com.edpl.cms.web.dto.CourseDto;
import com.edpl.cms.web.dto.UserDto;
import com.edpl.cms.web.exhandler.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AdminService {
    private final CourseService courseService;
    private final LectureService lectureService;
    private final ModuleService moduleService;
    private final UserService userService;

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

    @Transactional
    public UserDto getUserById(Long id) {
        return userService.getUserById(id);
    }

    @Transactional
    public UserDto deleteCourseFromUser(Long userId, Long courseId) {
        UserDto user = getUserById(userId);
        CourseDto deletableCourse = user.getCourses()
                .stream().filter(course -> course.getId().equals(courseId))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Course not found with courseId: "
                        + courseId + " from user with id: " + userId));

        Set<CourseDto> userCourses = user.getCourses();
        userCourses.remove(deletableCourse);
        user.setCourses(userCourses);

        return userService.update(user);
    }
}
