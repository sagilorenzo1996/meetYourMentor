package com.finalYearProject.meetYourMentor.controller;

import com.finalYearProject.meetYourMentor.domain.Grade;
import com.finalYearProject.meetYourMentor.domain.Student;
import com.finalYearProject.meetYourMentor.repo.GradeRepository;
import com.finalYearProject.meetYourMentor.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    StudentRepository studentRepository;

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
            grade.get().setDateOfExamination(newGrade.getDateOfExamination());
            grade.get().setMarks(newGrade.getMarks());
            grade.get().setStatus(newGrade.getStatus());
            grade.get().setStudent(newGrade.getStudent());
            gradeRepository.save(grade.get());
            gradeRepository.save(grade.get());
        }
        return "Grade deleted successfully";
    }

    @CrossOrigin
    @GetMapping("/grades/{id}")
    public Iterable<Grade> getStudentGrades(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent()) {
            throw new ResourceNotFoundException("Student Not Found");
        }
        Iterable<Grade> grade = gradeRepository.findByStudent(student.get());
        return grade;
    }

    


}
