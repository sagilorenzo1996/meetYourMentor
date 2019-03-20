package com.finalYearProject.meetYourMentor.repo;

import com.finalYearProject.meetYourMentor.domain.Lecturer;
import com.finalYearProject.meetYourMentor.domain.MeetingRequest;
import com.finalYearProject.meetYourMentor.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRequestRepository extends CrudRepository<MeetingRequest,Long> {
    Iterable<MeetingRequest> findAllByStudent(Student student);
    Iterable<MeetingRequest> findAllByLecturer(Lecturer lecturer);
}
