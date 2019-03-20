package com.finalYearProject.meetYourMentor.repo;

import com.finalYearProject.meetYourMentor.domain.Lecturer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends CrudRepository<Lecturer,Long> {
}
