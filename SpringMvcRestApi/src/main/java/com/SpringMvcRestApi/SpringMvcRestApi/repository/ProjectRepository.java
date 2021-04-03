package com.SpringMvcRestApi.SpringMvcRestApi.repository;

import com.SpringMvcRestApi.SpringMvcRestApi.model.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity,Long> {
}
