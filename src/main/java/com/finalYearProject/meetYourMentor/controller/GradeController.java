package com.finalYearProject.meetYourMentor.controller;

import com.finalYearProject.meetYourMentor.domain.Grade;
import com.finalYearProject.meetYourMentor.repo.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    GradeRepository gradeRepository;

    @CrossOrigin
    @PostMapping("/")
    public Grade createGrade(@Valid @RequestBody Grade grade) {
        return gradeRepository.save(grade);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Grade> getGrade(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<Grade> grade = gradeRepository.findById(id);
        if (!grade.isPresent()) {
            throw new ResourceNotFoundException("Grade Not Found");
        }
        return grade;
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public String deleteGrade(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<Grade> grade = gradeRepository.findById(id);
        if (!grade.isPresent()) {
            throw new ResourceNotFoundException("Grade Not Found");
        } else {
            gradeRepository.delete(grade.get());
        }
        return "Grade deleted successfully";
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public String updateGrade(@PathVariable(value = "id") Long id, @Valid @RequestBody Grade newGrade) throws ResourceNotFoundException {
        Optional<Grade> grade = gradeRepository.findById(id);
        if (!grade.isPresent()) {
            throw new ResourceNotFoundException("Grade Not Found");
        } else {
            gradeRepository.delete(grade.get());
        }
        return "Grade deleted successfully";
    }

}
