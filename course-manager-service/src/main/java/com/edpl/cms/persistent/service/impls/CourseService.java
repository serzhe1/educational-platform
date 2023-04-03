package com.edpl.cms.persistent.service.impls;

import com.edpl.cms.persistent.model.impls.Course;
import com.edpl.cms.persistent.repository.impls.CourseRepository;
import com.edpl.cms.persistent.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends AbstractService<Course, CourseRepository> {
    public CourseService(CourseRepository repository) {
        super(repository);
    }
}
