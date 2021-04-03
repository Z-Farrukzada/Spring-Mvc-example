package com.SpringMvcRestApi.SpringMvcRestApi.service.model;

import com.SpringMvcRestApi.SpringMvcRestApi.model.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DueDTO {

    private Integer id;
    private Date my_data;
    private Boolean recurring;
    private String my_string;

    private TaskEntity task;

}
