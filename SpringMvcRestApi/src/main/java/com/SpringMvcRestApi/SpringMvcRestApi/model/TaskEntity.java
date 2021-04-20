package com.SpringMvcRestApi.SpringMvcRestApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id",nullable = false)
    private Integer id;
    private Integer comment_count;
    private Boolean completed;
    @Size(max = 250)
    private String  content;
    @Size(max = 300)
    private String  url;
    private Integer orderdata;
    private Integer priority;


    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "due_id")
    private DueEntity due;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "task_project",joinColumns = {@JoinColumn(name = "task_id")}
                ,inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private List<ProjectEntity> project;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "TASK_LABEL",joinColumns = @JoinColumn(name = "TASK_ID",referencedColumnName = "task_id")
            ,inverseJoinColumns = @JoinColumn(name = "LABEL_ID",referencedColumnName = "label_id") )
    private List<LabelEntity> labels;


}
