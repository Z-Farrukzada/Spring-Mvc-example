package com.SpringMvcRestApi.SpringMvcRestApi.service.model;

import com.SpringMvcRestApi.SpringMvcRestApi.model.DueEntity;
import com.SpringMvcRestApi.SpringMvcRestApi.model.LabelEntity;
import com.SpringMvcRestApi.SpringMvcRestApi.model.ProjectEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTO {

    private Integer id;
    private Integer comment_count;
    private Boolean completed;
    private String  content;
    private String  url;
    private Integer orderdata;
    private Integer priority;


    private DueEntity due;
    private List<ProjectEntity> project;
    private List<LabelEntity> labels;

}
