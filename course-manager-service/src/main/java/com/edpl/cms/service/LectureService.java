package com.edpl.cms.service;

import com.edpl.cms.persistence.model.LectureEntity;
import com.edpl.cms.persistence.repository.LectureRepository;
import com.edpl.cms.web.dto.LectureDto;
import com.edpl.cms.web.exhandler.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;
    private final ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public LectureDto getById(Long id) {
        LectureEntity entity = lectureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lecture is not found with id: " + id));

        return modelMapper.map(entity, LectureDto.class);
    }

    @Transactional(readOnly = true)
    public List<LectureDto> getAll() {
        List<LectureEntity> lectures = lectureRepository.findAll();

        return lectures.stream().map(l -> modelMapper.map(l, LectureDto.class)).toList();
    }

    @Transactional
    public LectureDto save(LectureDto dto) {
        LectureEntity entity = new LectureEntity();
        entity.setName(dto.getName());
        entity.setContent(dto.getContent());
        entity.setModuleId(dto.getModuleId());

        entity = lectureRepository.save(entity);

        return modelMapper.map(entity, LectureDto.class);
    }

    @Transactional
    public LectureDto update(LectureDto dto) {
        LectureEntity entity = lectureRepository
                .findById(dto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Lecture not found with id: " + dto.getId()));

        entity.setName(dto.getName());
        entity.setContent(dto.getContent());

        entity = lectureRepository.save(entity);

        return modelMapper.map(entity, LectureDto.class);
    }

    @Transactional
    public void delete(Long id) {
        LectureEntity entity = lectureRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lecture not found with id: " + id));

        lectureRepository.deleteById(id);
    }
}
