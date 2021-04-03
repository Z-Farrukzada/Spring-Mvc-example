package com.SpringMvcRestApi.SpringMvcRestApi.controller;

import com.SpringMvcRestApi.SpringMvcRestApi.model.ProjectEntity;
import com.SpringMvcRestApi.SpringMvcRestApi.service.ProjectService;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.ProjectDTO;
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
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public List<ProjectDTO> getAllProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping("/{projectId}")
    public Optional<ProjectDTO> getProjectById(@PathVariable("projectId") Long projectId){
        return projectService.getProjectById(projectId);
    }

    @PostMapping("/create")
    public ProjectDTO save(@RequestBody  ProjectDTO projectDTO){
        return projectService.save(projectDTO);
    }

    @PutMapping("/update/{projectId}")
    public Optional<ProjectDTO> update(@PathVariable("projectId") Long projectId,@RequestBody ProjectDTO projectDTO){
        return projectService.update(projectId,projectDTO);
    }

    @DeleteMapping("/{projectId}")
    public void deleteById(@PathVariable  Long projectId){
         projectService.deleteById(projectId);
    }

}
