package com.finalYearProject.meetYourMentor.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data

@Entity
@Table(name = "Schedule")
public class Schedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Future
    private Date startTime;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Future
    private Date endTime;

    @NotNull
    private String type;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn
    private Lecturer lecturer;

}
