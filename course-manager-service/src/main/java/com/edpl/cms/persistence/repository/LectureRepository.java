package com.edpl.cms.persistence.repository;

import com.edpl.cms.persistence.model.LectureEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends CrudRepository<LectureEntity, Long> {
}