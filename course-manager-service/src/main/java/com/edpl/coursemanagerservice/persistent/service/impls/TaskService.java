package com.edpl.coursemanagerservice.persistent.service.impls;

import com.edpl.coursemanagerservice.persistent.model.impls.Task;
import com.edpl.coursemanagerservice.persistent.repository.impls.TaskRepository;
import com.edpl.coursemanagerservice.persistent.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class TaskService extends AbstractService<Task, TaskRepository> {
    public TaskService(TaskRepository repository) {
        super(repository);
    }

    public Task save(Task task) {
        if (task.getId() != null) {
            Task updatedTask = getById(task.getId());
            updatedTask.setAnswer(task.getAnswer());
            updatedTask.setText(updatedTask.getText());
            return repository.save(updatedTask);
        }
        return repository.save(task);
    }
}
