package com.finalYearProject.meetYourMentor.controller;

import com.finalYearProject.meetYourMentor.domain.Lecturer;
import com.finalYearProject.meetYourMentor.domain.Login;
import com.finalYearProject.meetYourMentor.repo.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/lecturer")
public class LecturerController {

    @Autowired
    LecturerRepository lecturerRepository;

    @CrossOrigin
    @PostMapping("/")
    public Long addLecturer(@Valid @RequestBody Lecturer lecturer) {
        return lecturerRepository.save(lecturer).getId();
    }

    @CrossOrigin
    @PostMapping("/login")
    public Object login(@Valid @RequestBody Login login) throws ResourceNotFoundException {
        Optional<Lecturer> lecturer = lecturerRepository.findByEmail(login.getUsername());
        if (!lecturer.isPresent()) {
            throw new ResourceNotFoundException("Lecturer Not Registered");
        }
        if (lecturer.get().getPassword().equals(login.getPassword())) {
            return lecturer.get();
        }
        return -1;
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Lecturer> getLecturer(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<Lecturer> lecturer = lecturerRepository.findById(id);
        if (!lecturer.isPresent()) {
            throw new ResourceNotFoundException("Lecturer Not Found");
        }
        return lecturer;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public String deleteLecturer(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<Lecturer> lecturer = lecturerRepository.findById(id);
        if (!lecturer.isPresent()) {
            throw new ResourceNotFoundException("Lecturer Not Found");
        } else {
            lecturerRepository.delete(lecturer.get());
        }
        return "Lecturer deleted successfully";
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public String updateLecturer(@PathVariable(value = "id") Long id, @Valid @RequestBody Lecturer newLecturer) throws ResourceNotFoundException {
        Optional<Lecturer> lecturer = lecturerRepository.findById(id);
        if (!lecturer.isPresent()) {
            throw new ResourceNotFoundException("Lecturer Not Found");
        } else {
            lecturer.get().setBio(newLecturer.getBio());
            lecturer.get().setEmail(newLecturer.getEmail());
            lecturer.get().setFaculty(newLecturer.getFaculty());
            lecturer.get().setFirstName(newLecturer.getFirstName());
            lecturer.get().setLastName(newLecturer.getLastName());
            lecturer.get().setPassword(newLecturer.getPassword());
            lecturer.get().setSubject(newLecturer.getSubject());
            lecturerRepository.save(lecturer.get());
        }
        return "Lecturer updated successfully";
    }

}
