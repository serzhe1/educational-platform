package com.edpl.cms.service;

import com.edpl.cms.persistence.model.CourseEntity;
import com.edpl.cms.persistence.model.UserEntity;
import com.edpl.cms.persistence.repository.UserRepository;
import com.edpl.cms.web.dto.CourseDto;
import com.edpl.cms.web.dto.UserDto;
import com.edpl.cms.web.exhandler.exceptions.ApplicationBadRequest;
import com.edpl.cms.web.exhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public UserEntity getUserEntity() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User is not found with name: " + username));

    }

    @Transactional
    public UserDto save(UserDto userDto) {
        if (userDto.getId() != null) {
            throw new ApplicationBadRequest("id should be null");
        }
        Set<CourseEntity> courses = userDto.getCourses().stream()
                .map(c -> modelMapper.map(c, CourseEntity.class))
                .collect(Collectors.toSet());

        UserEntity entity = new UserEntity();
        entity.setUsername(userDto.getUsername());
        entity.setFullName(userDto.getFullName());
        entity.setCourses(courses);
        entity = userRepository.save(entity);

        return modelMapper.map(entity, UserDto.class);
    }

    @Transactional
    public UserDto update(UserDto userDto) {
        UserEntity entity = getUserEntity();

        entity.setFullName(userDto.getFullName());
        Set<CourseEntity> courses = userDto.getCourses().stream()
                .map(c -> modelMapper.map(c, CourseEntity.class))
                .collect(Collectors.toSet());
        entity.setCourses(courses);
        entity = userRepository.save(entity);
        return modelMapper.map(entity, UserDto.class);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public UserDto getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntity entity = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User is not found with name: " + username));

        return modelMapper.map(entity, UserDto.class);
    }

    @Transactional(readOnly = true)
    public List<UserDto> getAll() {
        List<UserEntity> users = userRepository.findAll();

        return users.stream().map(u -> modelMapper.map(u, UserDto.class)).toList();
    }

    public List<CourseDto> getAllCoursesByUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserEntity userEntity = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User is not found with name: " + username));
        return userEntity.getCourses().stream().map(c -> modelMapper.map(c, CourseDto.class)).toList();
    }
}


