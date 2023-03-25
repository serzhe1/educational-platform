package com.edpl.cms.web.controller;

import com.edpl.cms.persistent.model.impls.Task;
import com.edpl.cms.persistent.service.impls.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping
    public List<Task> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Task getById(@RequestBody Task task) {
        return service.save(task);
    }
}
