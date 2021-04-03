package com.SpringMvcRestApi.SpringMvcRestApi.repository;

import com.SpringMvcRestApi.SpringMvcRestApi.model.LabelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends JpaRepository<LabelEntity,Long> {

}
