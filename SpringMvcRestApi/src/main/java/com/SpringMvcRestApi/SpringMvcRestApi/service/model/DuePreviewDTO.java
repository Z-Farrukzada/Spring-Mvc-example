package com.SpringMvcRestApi.SpringMvcRestApi.service.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DuePreviewDTO {

    private Integer id;
    private Date my_data;
    private Boolean recurring;
    private String my_string;

}
