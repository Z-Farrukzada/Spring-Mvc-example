package com.SpringMvcRestApi.SpringMvcRestApi.business;

import com.SpringMvcRestApi.SpringMvcRestApi.model.TaskEntity;
import com.SpringMvcRestApi.SpringMvcRestApi.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TaskManager {

   private final TaskRepository taskRepository;

   public List<TaskEntity> getAllTask(){
      return taskRepository.findAll();
   }

   public Optional<TaskEntity> getById(Long id){
      return taskRepository.findById(id);
   }

   public  TaskEntity save(TaskEntity taskEntity){
      return taskRepository.save(taskEntity);
   }

   public Optional<TaskEntity> update(Long id, TaskEntity taskEntity){
      return taskRepository.findById(id).map(t-> taskRepository.save(taskEntity));
   }

   public void deleteById(Long taskId){
      TaskEntity task = taskRepository.findById(taskId)
              .orElseThrow(() -> new NoSuchElementException("TaskEntity not found with id " + taskId));
      taskRepository.delete(task);
   }
}
