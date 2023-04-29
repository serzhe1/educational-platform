package com.edpl.cms.service;

import com.edpl.cms.persistence.repository.CourseRepository;
import com.edpl.cms.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;


}
