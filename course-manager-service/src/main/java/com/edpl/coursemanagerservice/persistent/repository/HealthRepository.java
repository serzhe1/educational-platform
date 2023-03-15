package com.edpl.coursemanagerservice.persistent.repository;

import com.edpl.coursemanagerservice.persistent.model.HealthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRepository extends JpaRepository<HealthEntity, Long> {
}
