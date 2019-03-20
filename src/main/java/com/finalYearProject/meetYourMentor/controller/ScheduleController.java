package com.finalYearProject.meetYourMentor.controller;

import com.finalYearProject.meetYourMentor.domain.Lecturer;
import com.finalYearProject.meetYourMentor.domain.Schedule;
import com.finalYearProject.meetYourMentor.repo.LecturerRepository;
import com.finalYearProject.meetYourMentor.repo.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {


    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    LecturerRepository lecturerRepository;

    @CrossOrigin
    @PostMapping("/")
    public Long createSchedule(@Valid @RequestBody Schedule schedule) {
        return scheduleRepository.save(schedule).getId();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Schedule> getSchedule(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<Schedule> schedule = scheduleRepository.findById(id);
        if (!schedule.isPresent()) {
            throw new ResourceNotFoundException("Schedule Not Found");
        }
        return schedule;
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public String deleteSchedule(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<Schedule> schedule = scheduleRepository.findById(id);
        if (!schedule.isPresent()) {
            throw new ResourceNotFoundException("Schedule Not Found");
        } else {
            scheduleRepository.delete(schedule.get());
        }
        return "Schedule deleted successfully";
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public String updateSchedule(@PathVariable(value = "id") Long id, @Valid @RequestBody Schedule newSchedule) throws ResourceNotFoundException {
        Optional<Schedule> schedule = scheduleRepository.findById(id);
        if (!schedule.isPresent()) {
            throw new ResourceNotFoundException("Schedule Not Found");
        } else {
            schedule.get().setEndTime(newSchedule.getEndTime());
            schedule.get().setName(newSchedule.getName());
            schedule.get().setStartTime(newSchedule.getStartTime());
            schedule.get().setType(newSchedule.getType());
            scheduleRepository.save(schedule.get());
        }
        return "Schedule updated successfully";
    }

    @CrossOrigin
    @GetMapping("/schedules/{id}")
    public Iterable<Schedule> getStudentGrades(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<Lecturer> lecturer = lecturerRepository.findById(id);
        if (!lecturer.isPresent()) {
            throw new ResourceNotFoundException("Lecturer Not Found");
        }
        Iterable<Schedule> schedule = scheduleRepository.findByLecturer(lecturer.get());
        return schedule;
    }
}
