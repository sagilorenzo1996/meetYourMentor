package com.finalYearProject.meetYourMentor.controller;

import com.finalYearProject.meetYourMentor.domain.Lecturer;
import com.finalYearProject.meetYourMentor.domain.Meet;
import com.finalYearProject.meetYourMentor.domain.MeetingRequest;
import com.finalYearProject.meetYourMentor.domain.Student;
import com.finalYearProject.meetYourMentor.repo.LecturerRepository;
import com.finalYearProject.meetYourMentor.repo.MeetingRequestRepository;
import com.finalYearProject.meetYourMentor.repo.ScheduleRepository;
import com.finalYearProject.meetYourMentor.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Optional;


@RestController
@RequestMapping("/meetingRequests")
public class MeetingRequestsController {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    LecturerRepository lecturerRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    MeetingRequestRepository meetingRequestRepository;

    @CrossOrigin
    @PostMapping("/meet")
    public Long addMeetingRequest(@RequestParam Long from, @RequestParam Long to, @RequestParam String acceptance, @Valid @RequestBody Meet meet) throws ResourceNotFoundException, InputMismatchException {
        Optional<Lecturer> lecturer = Optional.empty();
        Optional<Student> student = Optional.empty();
        if (acceptance.equals("LtoS")) {
            lecturer = lecturerRepository.findById(from);
            student = studentRepository.findById(to);
        } else if (acceptance.equals("StoL")) {
            lecturer = lecturerRepository.findById(from);
            student = studentRepository.findById(to);
        } else {
            throw new InputMismatchException("Wrong acceptance Criteria");
        }
        if (!student.isPresent() || !lecturer.isPresent()) {
            throw new ResourceNotFoundException("Student or Lecturer Not in system");
        }
        if (meet.equals(null)) {
            throw new InputMismatchException("Incorrect meeting request");
        }
        MeetingRequest meetingRequest = new MeetingRequest();
        meetingRequest.setAcceptance("No");
        meetingRequest.setAcceptedDateTime(null);
        meetingRequest.setSentDateTime(meet.getSentDateTime());
        meetingRequest.setType(meet.getType());
        meetingRequest.setReason(meet.getReason());
        meetingRequest.setVenue(meet.getVenue());
        meetingRequest.setStudent(student.get());
        meetingRequest.setLecturer(lecturer.get());
        return meetingRequestRepository.save(meetingRequest).getId();

    }

    @CrossOrigin
    @PostMapping("/accept/{id}")
    public Optional<MeetingRequest> acceptMeeting(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<MeetingRequest> meetingRequest = meetingRequestRepository.findById(id);
        if (!meetingRequest.isPresent()) {
            throw new ResourceNotFoundException("Request Not Found");
        }
        meetingRequest.get().setAcceptedDateTime(new Date());
        meetingRequest.get().setAcceptance("Yes");
        return meetingRequest;
    }

    @CrossOrigin
    @PostMapping("/decline/{id}")
    public Optional<MeetingRequest> declineMeeting(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<MeetingRequest> meetingRequest = meetingRequestRepository.findById(id);
        if (!meetingRequest.isPresent()) {
            throw new ResourceNotFoundException("Request Not Found");
        }
        meetingRequest.get().setAcceptedDateTime(new Date());
        meetingRequest.get().setAcceptance("Dec");
        return meetingRequest;
    }

    @CrossOrigin
    @GetMapping("/lecturer/{id}")
    public Iterable<MeetingRequest> declineMeeting(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        
    }


        @CrossOrigin
    @GetMapping("/student/{id}")




}
