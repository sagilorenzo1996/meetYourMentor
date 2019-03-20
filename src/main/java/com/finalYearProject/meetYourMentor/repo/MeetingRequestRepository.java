package com.finalYearProject.meetYourMentor.repo;

import com.finalYearProject.meetYourMentor.domain.MeetingRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRequestRepository extends CrudRepository<MeetingRequest,Long> {
}
