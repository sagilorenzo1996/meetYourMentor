package com.finalYearProject.meetYourMentor.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"meetingRequests","grades"})

@Entity
@Table(name = "Student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String degree;

    @NotNull
    @Size(min=20,max = 200)
    private String bio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date dateOfRegistration;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<MeetingRequest> meetingRequests;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Grade> grades;
}
