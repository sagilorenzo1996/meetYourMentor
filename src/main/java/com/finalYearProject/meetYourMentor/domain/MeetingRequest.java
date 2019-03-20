package com.finalYearProject.meetYourMentor.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data

@Entity
@Table(name = "MeetingRequest")
public class MeetingRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String acceptance;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sentDateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date acceptedDateTime;

    @NotNull
    private String type;

    @NotNull @Max(200)
    private String reason;

    @NotNull
    private String venue;

    @ManyToOne
    @JoinColumn
    private Student student;

    @ManyToOne
    @JoinColumn
    private Lecturer lecturer;

}
