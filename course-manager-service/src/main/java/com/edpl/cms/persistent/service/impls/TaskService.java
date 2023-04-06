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
//            updatedTask.setTheoryModuleId(task.getTheoryModuleId());  // ?? не понел нужно ли это, ведь по сути можно менять модуль, но будем ли - хз
//            updatedTask.setTheoryModule(task.getTheoryModule());
//            updatedTask.setDescription(task.getDescription());
            return repository.save(updatedTask);
        }

        return repository.save(task);
    }

}
