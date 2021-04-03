package com.SpringMvcRestApi.SpringMvcRestApi.repository;

import com.SpringMvcRestApi.SpringMvcRestApi.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Long> {

}
