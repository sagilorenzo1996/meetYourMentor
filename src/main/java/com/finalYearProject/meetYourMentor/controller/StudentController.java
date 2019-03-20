package com.finalYearProject.meetYourMentor.controller;


import com.finalYearProject.meetYourMentor.domain.Student;
import com.finalYearProject.meetYourMentor.domain.Login;
import com.finalYearProject.meetYourMentor.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @CrossOrigin
    @PostMapping("/")
    public Long addStudent(@Valid @RequestBody Student student) {
        return studentRepository.save(student).getId();
    }

    @CrossOrigin
    @PostMapping("/login")
    public Object login(@Valid @RequestBody Login login) throws ResourceNotFoundException {
        Optional<Student> student= studentRepository.findByEmail(login.getUsername());
        if(!student.isPresent()){
            throw new ResourceNotFoundException("Student Not Registered");
        }
        if(student.get().getPassword().equals(login.getPassword())){
            return student.get();
        }
        return -1;
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent()) {
            throw new ResourceNotFoundException("Student Not Found");
        }
        return student;
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent()) {
            throw new ResourceNotFoundException("Student Not Found");
        } else {
            studentRepository.delete(student.get());
        }
        return "Student deleted successfully";
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable(value = "id") Long id, @Valid @RequestBody Student newStudent) throws ResourceNotFoundException {
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent()) {
            throw new ResourceNotFoundException("Student Not Found");
        } else {
            student.get().setBio(newStudent.getBio());
            student.get().setEmail(newStudent.getEmail());
            student.get().setDateOfRegistration(newStudent.getDateOfRegistration());
            student.get().setFirstName(newStudent.getFirstName());
            student.get().setLastName(newStudent.getLastName());
            student.get().setPassword(newStudent.getPassword());
            student.get().setDegree(newStudent.getDegree());
            studentRepository.save(student.get());
        }
        return "Student updated successfully";
    }
}
