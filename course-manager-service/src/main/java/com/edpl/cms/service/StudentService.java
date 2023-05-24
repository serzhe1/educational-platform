package com.edpl.cms.service;

import com.edpl.cms.persistence.model.UserCoursesEntity;
import com.edpl.cms.persistence.repository.UserCoursesRepository;
import com.edpl.cms.web.dto.*;
import com.edpl.cms.web.exhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final UserCoursesRepository userCoursesRepository;
    private final CourseService courseService;
    private final ModuleService moduleService;
    private final TestService testService;
    private final LectureService lectureService;

     /*
     1. записаться на курс - есть
     2. просмотреть курс вместе с модулями и лекциями - будет в курс севрисах
     3. отписаться с курса - есть
     4. проходить тесты
     5. посмотреть список всех своих курсов - есть
     6. посмотреть свой курс, его модули и лекции
      */

    @Transactional
    public List<CourseInfoDto> signUpForCourse(Long courseId) {
        CourseDto course = courseService.findById(courseId);
        UserCoursesEntity entity = new UserCoursesEntity();
        entity.setUserUuid(getUserUUID());
        entity.setCourseId(course.getId());

        userCoursesRepository.save(entity);

        return getAllUserCourses();
    }



    @Transactional
    public List<CourseInfoDto> signOutForCourse(Long courseId) {
        userCoursesRepository.deleteByCourseIdAndUserUuid(courseId, getUserUUID());

        return getAllUserCourses();
    }

    @Transactional(readOnly = true)
    public List<CourseInfoDto> getAllUserCourses() {
        List<UserCoursesEntity> entities = userCoursesRepository.findAllByUserUuid(getUserUUID());
        Set<Long> coursesIds = entities.stream().map(UserCoursesEntity::getCourseId).collect(Collectors.toSet());

        return courseService.findAllByIdIn(new ArrayList<>(coursesIds));
    }

    @Transactional(readOnly = true)
    public CourseDto getCourseById(Long courseId) {
        UserCoursesEntity entity = userCoursesRepository.findByCourseIdAndUserUuid(courseId, getUserUUID())
                .orElseThrow(() -> new ResourceNotFoundException("Student is not sign in for course with id" + courseId));

        return courseService.findById(entity.getCourseId());
    }

    @Transactional(readOnly = true)
    public LectureDto getLectureById(Long id) {
        return lectureService.getById(id);
    }

    @Transactional(readOnly = true)
    public Set<TestDto> getAllTestByModuleId(Long moduleId) {
        return moduleService.getById(moduleId).getTests();
    }

    @Transactional
    public TestResultResponse setAnswerTest(ListAnswerRequest request) {
        List<TestDto> tests = testService.getByIdIn(request.getAnswer().stream().map(AnswerRequest::getTestId).toList());
        List<Long> answersIds = request.getAnswer().stream().map(AnswerRequest::getAnswerId).toList();

        int counter = 0;
        int isRightCounter = 0;
        for (TestDto test : tests) {
            counter ++;
            TestAnswerDto answer = test.getAnswers().stream()
                    .filter(a -> answersIds.contains(a.getId())).toList().get(0);
            if (answer != null && answer.getRight()) {
                isRightCounter ++;
            }
        }

        double percent = (double) isRightCounter /counter;
        return new TestResultResponse(counter, isRightCounter, percent);
    }
private String getUserUUID() {
    return  SecurityContextHolder.getContext().getAuthentication().getName();
}

}


