package com.SpringMvcRestApi.SpringMvcRestApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.beans.Transient;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id", nullable = false)
    private Integer id;
    @Size(max = 200)
    private String name;
    private Integer comment_count;
    private Integer orderdata;
    private Integer color;
    private Boolean shared;
    private Boolean favorite;
    private Boolean team_inbox;
    private Boolean inbox_project;
    @Size(max = 300)
    private String url;

}