package com.edpl.cms.persistence.repository;

import com.edpl.cms.persistence.model.LectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<LectureEntity, Long> {

}