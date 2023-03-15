package com.edpl.coursemanagerservice.persistent.service;

import com.edpl.coursemanagerservice.persistent.model.HealthEntity;
import com.edpl.coursemanagerservice.persistent.repository.HealthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HealthService {
    private final HealthRepository repository;

    public List<HealthEntity> getAll() {
        return repository.findAll();
    }
}
