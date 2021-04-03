package com.SpringMvcRestApi.SpringMvcRestApi.business;

import com.SpringMvcRestApi.SpringMvcRestApi.model.ProjectEntity;
import com.SpringMvcRestApi.SpringMvcRestApi.repository.ProjectRepository;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.ProjectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProjectManager {

    private final ProjectRepository projectRepository;

    public List<ProjectEntity> getAllProjects(){
        return projectRepository.findAll();
    }

    public Optional<ProjectEntity> getProjectById(Long id){
        return projectRepository.findById(id);
    }

    public ProjectEntity save(ProjectEntity projectEntity){
        return projectRepository.save(projectEntity);
    }

    public Optional<ProjectEntity> update(Long id, ProjectEntity projectEntity){
        return projectRepository.findById(id).map(pro-> projectRepository.save(projectEntity));
    }


    public void deleteById(Long projectId){
        ProjectEntity projectEntity =  projectRepository.findById(projectId)
                .orElseThrow(() -> new NoSuchElementException("ProjectEntity not found with id " +  projectId));
        projectRepository.delete(projectEntity);
    }


}
