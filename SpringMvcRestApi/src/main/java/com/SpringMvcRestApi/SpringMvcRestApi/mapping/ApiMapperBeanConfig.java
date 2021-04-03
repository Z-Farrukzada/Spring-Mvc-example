package com.SpringMvcRestApi.SpringMvcRestApi.mapping;

import com.SpringMvcRestApi.SpringMvcRestApi.model.LabelEntity;
import com.SpringMvcRestApi.SpringMvcRestApi.model.ProjectEntity;
import com.SpringMvcRestApi.SpringMvcRestApi.model.TaskEntity;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.LabelDTO;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.ProjectDTO;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.TaskDTO;
import com.remondis.remap.Mapper;
import com.remondis.remap.Mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiMapperBeanConfig {

    //Label And LabelDTO

    @Bean
    public Mapper<LabelEntity,LabelDTO> labelEntityDtoMapper() {
        return Mapping.from(LabelEntity.class)
                .to(LabelDTO.class)
                .mapper();
    }

    @Bean
    public Mapper<LabelDTO,LabelEntity> labelDTOEntityMapper() {
        return Mapping.from(LabelDTO.class)
                .to(LabelEntity.class)
                .mapper();
    }

    //Project And ProjectDTo

    @Bean
    public Mapper<ProjectEntity, ProjectDTO> projectEntityProjectDTOMapper() {
        return Mapping.from(ProjectEntity.class)
                .to(ProjectDTO.class)
                .mapper();
    }

    @Bean
    public Mapper<ProjectDTO,ProjectEntity> projectDTOProjectEntityMapper() {
        return Mapping.from(ProjectDTO.class)
                .to(ProjectEntity.class)
                .mapper();
    }

    // TaskEntity And TaskDto

    @Bean
    public Mapper<TaskEntity, TaskDTO> taskEntityTaskDTOMapper() {
        return Mapping.from(TaskEntity.class)
                .to(TaskDTO.class)
                .mapper();
    }

    @Bean
    public Mapper<TaskDTO,TaskEntity> taskDTOTaskEntityMapper() {
        return Mapping.from(TaskDTO.class)
                .to(TaskEntity.class)
                .mapper();
    }


}
