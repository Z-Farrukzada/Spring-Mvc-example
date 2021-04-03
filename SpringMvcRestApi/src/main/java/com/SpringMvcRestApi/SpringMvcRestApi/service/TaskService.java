package com.SpringMvcRestApi.SpringMvcRestApi.service;

import com.SpringMvcRestApi.SpringMvcRestApi.business.TaskManager;
import com.SpringMvcRestApi.SpringMvcRestApi.model.TaskEntity;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.TaskDTO;
import com.remondis.remap.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {


    private final TaskManager taskManager;
    private final Mapper<TaskEntity, TaskDTO> taskEntityTaskDTOMapper;
    private final Mapper<TaskDTO,TaskEntity> taskDTOTaskEntityMapper;

    public List<TaskDTO> getAlTask(){
       return taskEntityTaskDTOMapper.map(taskManager.getAllTask());
    }

    public Optional<TaskDTO> getById(Long id){
        return taskManager.getById(id).map(taskEntityTaskDTOMapper::map);
    }

    public TaskDTO save(TaskDTO taskDTO){
       return taskEntityTaskDTOMapper.map(taskManager.save(taskDTOTaskEntityMapper.map(taskDTO)));
    }


    public Optional<TaskDTO> update(Long id,TaskDTO taskDTO){
       return taskManager.update(id,taskDTOTaskEntityMapper.map(taskDTO)).map(taskEntityTaskDTOMapper::map);
    }


    public void deleteById(Long taskId){
        taskManager.deleteById(taskId);
    }
}
