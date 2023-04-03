package com.edpl.cms.persistent.service.impls;

import com.edpl.cms.persistent.model.impls.Task;
import com.edpl.cms.persistent.repository.impls.TaskRepository;
import com.edpl.cms.persistent.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class TaskService extends AbstractService<Task, TaskRepository> {
    public TaskService(TaskRepository repository) {
        super(repository);
        this.notFoundMassage = "task is unfounded with id: ";
    }

    public Task save(Task task) {
        if (task.getId() != null) {
            Task updatedTask = getById(task.getId());
            return repository.save(updatedTask);
        }
        return repository.save(task);
    }
}
