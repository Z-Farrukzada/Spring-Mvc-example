package com.SpringMvcRestApi.SpringMvcRestApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DueEntity  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "due_id",unique = true)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date my_data;
    private Boolean recurring;
    @Size(max = 300)
    private String my_string;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "due")
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private  TaskEntity task;

}
