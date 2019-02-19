package com.finalYearProject.meetYourMentor.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@Data
@EqualsAndHashCode(exclude = {"schedules","meetingRequests"})

@Entity
@Table(name = "Lecturer")
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private  String lastName;

    @NotNull
    private String subject;

    @NotNull
    private String faculty;

    @NotNull
    @Size(min=20,max = 200)
    private String bio;

    @OneToMany(mappedBy = "lecturer", cascade = CascadeType.ALL)
    private Set<MeetingRequest> meetingRequests;

    @OneToMany(mappedBy = "lecturer", cascade = CascadeType.ALL)
    private Set<Schedule> schedules;

}
