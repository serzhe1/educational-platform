package com.edpl.cms.service;

import com.edpl.cms.persistence.model.CourseEntity;
import com.edpl.cms.persistence.model.ModuleEntity;
import com.edpl.cms.persistence.repository.CourseRepository;
import com.edpl.cms.persistence.repository.ModuleRepository;
import com.edpl.cms.web.dto.ModuleDto;
import com.edpl.cms.web.exhandler.exceptions.ApplicationBadRequest;
import com.edpl.cms.web.exhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleService {
    private final ModuleRepository moduleRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;


    @Transactional
    public ModuleDto save(ModuleDto dto) {
        if (dto.getCourseId() == null) {
            throw new ApplicationBadRequest("Module should be has course_id.");
        }

        CourseEntity course = courseRepository.findByIdAndOwnerUUID(dto.getCourseId(), getAuth().getName())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Course with id=%d not found", dto.getCourseId())));

        ModuleEntity moduleEntity = new ModuleEntity();
        moduleEntity.setName(dto.getName());
        moduleEntity.setDescription(dto.getDescription());
        moduleEntity.setCourseId(dto.getCourseId());
        moduleEntity = moduleRepository.save(moduleEntity);
        return modelMapper.map(moduleEntity, ModuleDto.class);
    }

    @Transactional
    public ModuleDto update(ModuleDto dto) {
        CourseEntity course = courseRepository.findByIdAndOwnerUUID(dto.getCourseId(), getAuth().getName())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Course with id=%d not found", dto.getCourseId())));

        ModuleEntity moduleEntity = course.getModules().stream()
                .filter(m -> m.getId().equals(dto.getId()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Module is not found with id" + dto.getId()));

        moduleEntity.setName(dto.getName());
        moduleEntity.setDescription(dto.getDescription());

        moduleEntity = moduleRepository.save(moduleEntity);

        return modelMapper.map(moduleEntity, ModuleDto.class);
    }

    @Transactional(readOnly = true)
    public ModuleDto getById(Long id) {
        ModuleEntity moduleEntity =  moduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Module not found with id: " + id));

        return modelMapper.map(moduleEntity, ModuleDto.class);
    }

    @Transactional
    public void deleteById(Long id) {
        ModuleEntity moduleEntity = moduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Module not found with id: " + id));

        moduleRepository.deleteById(id);
    }
    private Authentication getAuth() {
        return  SecurityContextHolder.getContext().getAuthentication();
    }

}
