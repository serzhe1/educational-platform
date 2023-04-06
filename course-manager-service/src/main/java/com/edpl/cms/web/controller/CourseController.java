package com.edpl.cms.web.controller;

import com.edpl.cms.persistent.model.impls.Course;
import com.edpl.cms.persistent.service.impls.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService service;

    @GetMapping
    public List<Course> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Course saveOrUpdate(@RequestBody Course course) {
        return service.save(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
