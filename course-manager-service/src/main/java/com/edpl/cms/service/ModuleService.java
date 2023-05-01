package com.edpl.cms.service;

import com.edpl.cms.persistence.model.ModuleEntity;
import com.edpl.cms.persistence.repository.ModuleRepository;
import com.edpl.cms.web.dto.ModuleDto;
import com.edpl.cms.web.exhandler.exceptions.ApplicationBadRequest;
import com.edpl.cms.web.exhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleService {
    private final ModuleRepository moduleRepository;
    private final ModelMapper modelMapper;


    @Transactional
    public ModuleDto save(ModuleDto dto) {
        if (dto.getCourseId() == null) {
            throw new ApplicationBadRequest("Module should be has course_id.");
        }

        ModuleEntity moduleEntity = new ModuleEntity();
        moduleEntity.setName(dto.getName());
        moduleEntity.setDescription(dto.getDescription());
        moduleEntity.setCourseId(dto.getCourseId());

        moduleEntity = moduleRepository.save(moduleEntity);

        return modelMapper.map(moduleEntity, ModuleDto.class);
    }

    @Transactional
    public ModuleDto update(ModuleDto dto) {
        ModuleEntity moduleEntity = new ModuleEntity();

        moduleEntity.setName(dto.getName());
        moduleEntity.setDescription(dto.getDescription());

        moduleEntity = moduleRepository.save(moduleEntity);

        return modelMapper.map(moduleEntity, ModuleDto.class);
    }

    @Transactional(readOnly = true)
    public List<ModuleDto> getAll() {
        List<ModuleEntity> modules = moduleRepository.findAll();
        return modules.stream().map(m -> modelMapper.map(m, ModuleDto.class)).toList();
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
}
