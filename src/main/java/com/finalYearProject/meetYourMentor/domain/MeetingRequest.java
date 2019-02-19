package com.finalYearProject.meetYourMentor.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data

@Entity
@Table(name = "MeetingRequest")
public class MeetingRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String acceptance;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private Date sentDateTime;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
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
