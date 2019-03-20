package com.finalYearProject.meetYourMentor.controller;

import com.finalYearProject.meetYourMentor.domain.Grade;
import com.finalYearProject.meetYourMentor.domain.Lecturer;
import com.finalYearProject.meetYourMentor.repo.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/lecturer")
public class LecturerController {

    @Autowired
    LecturerRepository lecturerRepository;

    @CrossOrigin
    @PostMapping("/")
    public Lecturer addLecturer(@Valid @RequestBody Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }

    @PostMapping("/get")
    public String Test() {
        return "Hiiii";
    }

}
