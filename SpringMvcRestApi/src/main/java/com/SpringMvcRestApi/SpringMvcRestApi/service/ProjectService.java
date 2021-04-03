package com.SpringMvcRestApi.SpringMvcRestApi.service;

import com.SpringMvcRestApi.SpringMvcRestApi.business.ProjectManager;
import com.SpringMvcRestApi.SpringMvcRestApi.model.ProjectEntity;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.ProjectDTO;
import com.remondis.remap.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectManager projectManager;
    private final Mapper<ProjectEntity, ProjectDTO> projectEntityProjectDTOMapper;
    private final Mapper<ProjectDTO, ProjectEntity> projectDTOProjectEntityMapper;

    public List<ProjectDTO> getAllProjects() {
        return projectEntityProjectDTOMapper.map(projectManager.getAllProjects());
    }

    public Optional<ProjectDTO> getProjectById(Long projectId) {
        return projectManager.getProjectById(projectId).map(projectEntityProjectDTOMapper::map);
    }

    public ProjectDTO save(ProjectDTO projectDTO) {
        return projectEntityProjectDTOMapper.map(projectManager.save(projectDTOProjectEntityMapper.map(projectDTO)));
    }

    public Optional<ProjectDTO> update(Long projectId, ProjectDTO projectDTO) {
        return projectManager.update(projectId, projectDTOProjectEntityMapper.map(projectDTO)).map(projectEntityProjectDTOMapper::map);
    }

    public void deleteById(Long projectId) {
        projectManager.deleteById(projectId);
    }

}
