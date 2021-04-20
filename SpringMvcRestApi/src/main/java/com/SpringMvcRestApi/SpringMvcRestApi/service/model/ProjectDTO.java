package com.SpringMvcRestApi.SpringMvcRestApi.service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {


    private Integer id;
    private String name;
    private Integer comment_count;
    private Integer orderdata;
    private Integer color;
    private Boolean shared;
    private Boolean favorite;
    private Boolean team_inbox;
    private Boolean inbox_project;
    private String url;

}
