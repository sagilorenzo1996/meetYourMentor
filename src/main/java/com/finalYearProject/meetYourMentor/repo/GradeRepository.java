package com.finalYearProject.meetYourMentor.repo;

import com.finalYearProject.meetYourMentor.domain.Grade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends CrudRepository<Grade,Long> {
}
