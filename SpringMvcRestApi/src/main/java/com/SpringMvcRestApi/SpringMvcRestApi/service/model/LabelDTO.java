package com.SpringMvcRestApi.SpringMvcRestApi.service.model;

import com.SpringMvcRestApi.SpringMvcRestApi.model.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LabelDTO {

    private Integer id;
    private String name;
    private Integer color;
    private Integer data;
    private  Boolean favorite;

}
