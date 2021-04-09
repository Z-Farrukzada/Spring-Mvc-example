package com.SpringMvcRestApi.SpringMvcRestApi.mapping;

import com.SpringMvcRestApi.SpringMvcRestApi.model.DueEntity;
import com.SpringMvcRestApi.SpringMvcRestApi.model.LabelEntity;
import com.SpringMvcRestApi.SpringMvcRestApi.model.ProjectEntity;
import com.SpringMvcRestApi.SpringMvcRestApi.model.TaskEntity;
import com.SpringMvcRestApi.SpringMvcRestApi.model.User;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.DuePreviewDTO;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.LabelDTO;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.LabelPreviewDTO;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.ProjectDTO;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.ProjectPreviewDTO;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.TaskDTO;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.UserDTO;
import com.remondis.remap.Mapper;
import com.remondis.remap.Mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiMapperBeanConfig {

    //userDTO mapping user

    @Bean
    public Mapper<UserDTO, User> userDTOUserMapper(){
        return Mapping.from(UserDTO.class)
                .to(User.class)
                .mapper();
    }

    //Label And LabelDTO

    @Bean
    public Mapper<LabelEntity, LabelDTO> labelEntityDtoMapper() {
        return Mapping.from(LabelEntity.class)
                .to(LabelDTO.class)
                .mapper();
    }

    @Bean
    public Mapper<LabelDTO, LabelEntity> labelDTOEntityMapper() {
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
    public Mapper<ProjectDTO, ProjectEntity> projectDTOProjectEntityMapper() {
        return Mapping.from(ProjectDTO.class)
                .to(ProjectEntity.class)
                .mapper();
    }

    @Bean
    public Mapper<ProjectEntity, ProjectPreviewDTO> projectEntityProjectPreviewDTO() {
        return Mapping.from(ProjectEntity.class)
                .to(ProjectPreviewDTO.class)
                .omitInSource(ProjectEntity::getColor)
                .omitInSource(ProjectEntity::getInbox_project)
                .omitInSource(ProjectEntity::getFavorite)
                .omitInSource(ProjectEntity::getComment_count)
                .omitInSource(ProjectEntity::getOrderdata)
                .omitInSource(ProjectEntity::getShared)
                .omitInSource(ProjectEntity::getTeam_inbox)
                .omitInSource(ProjectEntity::getUrl)
                .mapper();

    }

    @Bean
    public Mapper<ProjectPreviewDTO, ProjectEntity> projectPreviewDTOProjectEntity() {
        return Mapping.from(ProjectPreviewDTO.class)
                .to(ProjectEntity.class)
                .omitInDestination(ProjectEntity::getColor)
                .omitInDestination(ProjectEntity::getInbox_project)
                .omitInDestination(ProjectEntity::getFavorite)
                .omitInDestination(ProjectEntity::getComment_count)
                .omitInDestination(ProjectEntity::getOrderdata)
                .omitInDestination(ProjectEntity::getShared)
                .omitInDestination(ProjectEntity::getTeam_inbox)
                .omitInDestination(ProjectEntity::getUrl)
                .mapper();
    }

    // TaskEntity And TaskDto

    @Bean
    public Mapper<TaskEntity, TaskDTO> taskEntityTaskDTOMapper() {
        return Mapping.from(TaskEntity.class)
                .to(TaskDTO.class)
                .useMapper(labelEntityPreviewDTOMapper())
                .useMapper(projectEntityProjectPreviewDTO())
                .useMapper(dueEntityDuePreviewDTO())
                .mapper();
    }

    @Bean
    public Mapper<DueEntity, DuePreviewDTO> dueEntityDuePreviewDTO() {
        return Mapping
                .from(DueEntity.class)
                .to(DuePreviewDTO.class)
                .omitInSource(DueEntity::getTask)
                .mapper();
    }

    @Bean
    public Mapper<DuePreviewDTO,DueEntity> duePreviewDTODueEntity() {
        return Mapping
                .from(DuePreviewDTO.class)
                .to(DueEntity.class)
                .omitInDestination(DueEntity::getTask)
                .mapper();
    }


    @Bean
    public Mapper<LabelEntity, LabelPreviewDTO> labelEntityPreviewDTOMapper() {
        return Mapping.from(LabelEntity.class)
                .to(LabelPreviewDTO.class)
                .omitInSource(LabelEntity::getData)
                .omitInSource(LabelEntity::getColor)
                .omitInSource(LabelEntity::getFavorite)
                .mapper();
    }

    @Bean
    public Mapper<LabelPreviewDTO, LabelEntity> labelPreviewDTOEntityMapper() {
        return Mapping.from(LabelPreviewDTO.class)
                .to(LabelEntity.class)
                .omitInDestination(LabelEntity::getData)
                .omitInDestination(LabelEntity::getColor)
                .omitInDestination(LabelEntity::getFavorite)
                .mapper();
    }

    @Bean
    public Mapper<TaskDTO, TaskEntity> taskDTOTaskEntityMapper() {
        return Mapping.from(TaskDTO.class)
                .to(TaskEntity.class)
                .useMapper(labelPreviewDTOEntityMapper())
                .useMapper(projectPreviewDTOProjectEntity())
                .useMapper(duePreviewDTODueEntity())
                .mapper();
    }


}
