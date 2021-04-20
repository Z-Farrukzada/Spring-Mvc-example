package com.SpringMvcRestApi.SpringMvcRestApi.controller;

import com.SpringMvcRestApi.SpringMvcRestApi.service.TaskService;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.TaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    private List<TaskDTO> getAllTasks() {
        return taskService.getAlTask();
    }

    @GetMapping("/{taskId}")
    public Optional<TaskDTO> getById(@PathVariable("taskId") Long taskId) {
        return taskService.getById(taskId);
    }

    @PostMapping("/create")
    public TaskDTO save(@RequestBody TaskDTO taskDTO) {
        return taskService.save(taskDTO);
    }

    @PutMapping("/update/{taskId}")
    public Optional<TaskDTO> update(@PathVariable("taskId") Long taskId, @RequestBody TaskDTO taskDTO) {
        return taskService.update(taskId, taskDTO);
    }

    @DeleteMapping("/{taskId}")
    public void delete(@PathVariable("taskId") Long taskId) {
        taskService.deleteById(taskId);
    }
}
