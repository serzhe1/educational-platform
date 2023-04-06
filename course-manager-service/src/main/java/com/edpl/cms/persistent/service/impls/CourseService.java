package com.edpl.cms.persistent.service.impls;

import com.edpl.cms.persistent.model.impls.Course;
import com.edpl.cms.persistent.repository.impls.CourseRepository;
import com.edpl.cms.persistent.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends AbstractService<Course, CourseRepository> {
    public CourseService(CourseRepository repository) {
        super(repository);
        this.notFoundMassage = "course is unfounded with id: ";
    }


    public Course save(Course course) {
        if (course.getId() != null) {
            Course updatedCourse = getById(course.getId());
            updatedCourse.setName(course.getName());
            updatedCourse.setDescription(course.getDescription());
            updatedCourse.setUsers(course.getUsers());
            return repository.save(updatedCourse);
        }
        return repository.save(course);
    }


}
