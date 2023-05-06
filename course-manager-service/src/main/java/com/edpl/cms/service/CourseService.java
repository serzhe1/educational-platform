package com.edpl.cms.service;

import com.edpl.cms.persistence.model.CourseEntity;
import com.edpl.cms.persistence.repository.CourseRepository;
import com.edpl.cms.web.dto.CourseDto;
import com.edpl.cms.web.dto.CourseInfoDto;
import com.edpl.cms.web.exhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final ModelMapper modelMapper;

    private final CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public List<CourseInfoDto> findAll() {
        return courseRepository
                .findAll().stream()
                .map(courseEntity -> modelMapper.map(courseEntity, CourseDto.class))
				.map(c -> modelMapper.map(c, CourseInfoDto.class))
				.toList();
    }

    @Transactional(readOnly = true)
    public CourseDto findById(Long id) {
        CourseEntity ce = courseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Course with {id=%d} not found.", id)));

        return modelMapper.map(ce, CourseDto.class);
    }

    @Transactional
    public CourseDto save(CourseDto courseDto) {
        CourseEntity toSave = modelMapper.map(courseDto, CourseEntity.class);

        CourseEntity course = courseRepository.save(toSave);

        courseDto.setId(course.getId());

        return courseDto;
    }

    @Transactional
    public CourseDto update(CourseDto courseDto) {
        CourseEntity course = courseRepository.findById(courseDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Course with id=%d not found", courseDto.getId())));

        course.setName(courseDto.getName());
        course.setCompetencies(courseDto.getCompetencies());
        course.setFormat(courseDto.getFormat());
        course.setDescription(courseDto.getDescription());
        course.setRequirements(course.getRequirements());

        courseRepository.save(course);

        return courseDto;
    }

    @Transactional
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<CourseInfoDto> findAllByName(String namePattern) {
        List<CourseEntity> coursesByName = courseRepository.findAllByNameContaining(namePattern);

        return coursesByName.stream()
                .map(courseEntity -> modelMapper.map(courseEntity, CourseDto.class))
                .map(c -> modelMapper.map(c, CourseInfoDto.class))
                .toList();
    }
}
