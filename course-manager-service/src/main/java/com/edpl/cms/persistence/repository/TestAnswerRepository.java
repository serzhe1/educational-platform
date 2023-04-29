package com.edpl.cms.persistence.repository;

import com.edpl.cms.persistence.model.TestAnswersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestAnswerRepository extends CrudRepository<TestAnswersEntity, Long> {
}
