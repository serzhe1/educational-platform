package com.edpl.cms.service;

import com.edpl.cms.persistence.model.TestAnswersEntity;
import com.edpl.cms.persistence.repository.TestAnswerRepository;
import com.edpl.cms.web.dto.TestAnswerDto;
import com.edpl.cms.web.dto.TestDto;
import com.edpl.cms.web.exhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestAnswerService {
    private final TestAnswerRepository testAnswerRepository;
    private final ModelMapper modelMapper;

    public TestAnswerDto save(TestDto request) {
        //todo bad request
        TestAnswersEntity entity = modelMapper.map(request, TestAnswersEntity.class);
        entity = testAnswerRepository.save(entity);
        return modelMapper.map(entity, TestAnswerDto.class);
    }

    public List<TestAnswerDto> getAll() {
        return testAnswerRepository.findAll().stream()
                .map(t -> modelMapper.map(t, TestAnswerDto.class))
                .toList();
    }

    public TestAnswerDto getById(Long id) {
        TestAnswersEntity entity = testAnswerRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Test is not found with id: " + id));

        return modelMapper.map(entity, TestAnswerDto.class);
    }

    public List<TestAnswerDto> saveAll(List<TestAnswerDto> answers) {
        List<TestAnswersEntity> entities = answers.stream()
                .map(a -> modelMapper.map(a, TestAnswersEntity.class))
                .toList();
        entities = testAnswerRepository.saveAll(entities);

        return entities.stream()
                .map(a -> modelMapper.map(a, TestAnswerDto.class))
                .toList();
    }
}
