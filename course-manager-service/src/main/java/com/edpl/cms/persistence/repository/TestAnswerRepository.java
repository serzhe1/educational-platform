package com.edpl.cms.persistence.repository;

import com.edpl.cms.persistence.model.TestAnswersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestAnswerRepository extends JpaRepository<TestAnswersEntity, Long> {
}
