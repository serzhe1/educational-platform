package com.edpl.coursemanagerservice.persistent.repository.impls;

import com.edpl.coursemanagerservice.persistent.model.impls.Task;
import com.edpl.coursemanagerservice.persistent.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CommonRepository<Task> {
}
