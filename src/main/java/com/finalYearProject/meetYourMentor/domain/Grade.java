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
@Table(name="Grade")
public class Grade  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateOfExamination;

    @NotNull
    private String status;

    @NotNull
    private int marks;

    @ManyToOne
    @JoinColumn
    private Student student;
}
