package com.edpl.cms.service;

import com.edpl.cms.persistence.model.UserEntity;
import com.edpl.cms.web.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final UserService userService;
    private final CourseService courseService;

    private final ModelMapper modelMapper;

    @Transactional
    public List<CourseDto> getAllStudentCourses() {
        UserEntity userEntity = userService.getUserEntity();

        return userEntity.getCourses().stream().map(c -> modelMapper.map(c, CourseDto.class)).toList();

    }
}


