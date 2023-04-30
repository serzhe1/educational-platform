package com.edpl.cms.service;

import com.edpl.cms.web.dto.CourseDto;
import com.edpl.cms.web.dto.UserDto;
import com.edpl.cms.web.exhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final UserService userService;
    private final CourseService courseService;
    private final ModuleService moduleService;
    private final TestService testService;
    private final ModelMapper modelMapper;

     /*
     1. записаться на курс - есть
     2. просмотреть курс вместе с модулями и лекциями - будет в курс севрисах
     3. отписаться с курса
     4. проходить тесты
     5. посмотреть список всех своих курсов
     6. посмотреть свой курс, его модули и лекции
      */

    public UserDto signUpForCourse(Long courseId) {
        CourseDto course = courseService.findById(courseId);
        UserDto user = userService.getUser();
        user.getCourses().add(course);
        return userService.update(user);
    }

    public UserDto signOutForCourse(Long courseId) {
        UserDto user = userService.getUser();
        CourseDto course = user.getCourses().stream()
                .filter(c -> c.getId().equals(courseId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Course is not founded with id:" + courseId));
        user.getCourses().remove(course);
        return userService.update(user);
    }

    public Set<CourseDto> getAllUserCourses() {
        return userService.getUser().getCourses();
    }


}


