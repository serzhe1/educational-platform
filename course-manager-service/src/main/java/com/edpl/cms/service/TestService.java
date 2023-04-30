package com.edpl.cms.service;

import com.edpl.cms.persistence.model.TestEntity;
import com.edpl.cms.persistence.repository.TestRepository;
import com.edpl.cms.web.dto.TestAnswerDto;
import com.edpl.cms.web.dto.TestDto;
import com.edpl.cms.web.exhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public TestDto save(TestDto request) {
        TestEntity entity = modelMapper.map(request, TestEntity.class);
        entity = testRepository.save(entity);
        return modelMapper.map(entity, TestDto.class);
    }

    @Transactional(readOnly = true)
    public List<TestDto> getAllByModule(Long module) {
        return testRepository.findAllByModuleId(module).stream()
                .map(t -> modelMapper.map(t, TestDto.class))
                .toList();
    }

    @Transactional(readOnly = true)
    public TestDto getById(Long id) {
        TestEntity entity = testRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Test is not found with id: " + id));
        return modelMapper.map(entity, TestDto.class);
    }
}
