package com.edpl.cms.service;

import com.edpl.cms.persistence.model.TestAnswersEntity;
import com.edpl.cms.persistence.model.TestEntity;
import com.edpl.cms.persistence.repository.TestAnswerRepository;
import com.edpl.cms.persistence.repository.TestRepository;
import com.edpl.cms.web.dto.TestAnswerDto;
import com.edpl.cms.web.dto.TestDto;
import com.edpl.cms.web.exhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;
    private final TestAnswerRepository testAnswerRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public TestDto save(TestDto request) {
        TestEntity entity = new TestEntity();
        entity.setModuleId(request.getModule());
        entity.setId(request.getId());
        entity.setQuestion(request.getQuestion());
        Set<TestAnswersEntity> answersEntities = request.getAnswers().stream()
                .map(a -> {
                    TestAnswersEntity answer = new TestAnswersEntity();
                    answer.setAnswer(a.getAnswer());
                    answer.setId(a.getId());
                    answer.setRight(a.getRight());
                    return answer;
                })
                .collect(Collectors.toSet());
        entity = testRepository.save(entity);
        answersEntities = new HashSet<>(testAnswerRepository.saveAll(answersEntities));
        entity.setTestAnswers(answersEntities);
        TestDto response = modelMapper.map(entity, TestDto.class);
        response.setAnswers(entity.getTestAnswers().stream().map(a -> modelMapper.map(a, TestAnswerDto.class)).toList());
        return response;
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

    @Transactional(readOnly = true)
    public List<TestDto> getByIdIn(List<Long> ids) {
        List<TestEntity> entities = testRepository.findAllByIdIn(ids);
        return entities.stream()
                .map(entity -> modelMapper.map(entity, TestDto.class))
                .toList();
    }

}
