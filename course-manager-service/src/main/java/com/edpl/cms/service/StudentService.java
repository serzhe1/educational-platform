package com.edpl.cms.service;

import com.edpl.cms.web.dto.*;
import com.edpl.cms.web.exhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final CourseService courseService;
    private final ModuleService moduleService;
    private final TestService testService;
    private final ModelMapper modelMapper;
    private final LectureService lectureService;

     /*
     1. записаться на курс - есть
     2. просмотреть курс вместе с модулями и лекциями - будет в курс севрисах
     3. отписаться с курса - есть
     4. проходить тесты
     5. посмотреть список всех своих курсов - есть
     6. посмотреть свой курс, его модули и лекции
      */

//    @Transactional
//    public UserDto signUpForCourse(Long courseId) {
//        CourseDto course = courseService.findById(courseId);
//        UserDto user = userService.getUser();
//        user.getCourses().add(course);
//        return userService.update(user);
//    }
//
//    @Transactional
//    public UserDto signOutForCourse(Long courseId) {
//        UserDto user = userService.getUser();
//        CourseDto course = user.getCourses().stream()
//                .filter(c -> c.getId().equals(courseId))
//                .findFirst()
//                .orElseThrow(() -> new ResourceNotFoundException("Course is not founded with id:" + courseId));
//        user.getCourses().remove(course);
//        return userService.update(user);
//    }
//
//    @Transactional(readOnly = true)
//    public Set<CourseDto> getAllUserCourses() {
//        return userService.getUser().getCourses();
//    }
//
//    @Transactional(readOnly = true)
//    public CourseDto getCourseById(Long courseId) {
//        return userService.getUser().getCourses().stream()
//                .filter(c -> c.getId().equals(courseId))
//                .findFirst()
//                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));
//    }
//
//    @Transactional(readOnly = true)
//    public LectureDto getLectureById(Long id) {
//        return lectureService.getById(id);
//    }
//
//    @Transactional(readOnly = true)
//    public Set<TestDto> getAllTestByModuleId(Long moduleId) {
//        return moduleService.getById(moduleId).getTests();
//    }
//
//    @Transactional
//    public UserDto setAnswerTest(AnswerRequest request) {
//        UserDto user = userService.getUser();
//        TestDto test = testService.getById(request.getTestId());
//        TestAnswerDto answer = test.getAnswers().stream()
//                .filter(a -> a.getId().equals(request.getAnswerId()))
//                .findFirst()
//                .orElseThrow(() -> new ResourceNotFoundException(
//                        "In test " + request.getTestId() + "answer is not found with id: " + request.getAnswerId()));
//        user.getAnswers().add(answer);
//        return userService.update(user);
//    }

}


