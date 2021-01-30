package com.springmvc.vietjob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.vietjob.model.Applicant;
import com.springmvc.vietjob.model.JobSaved;



@Repository
public interface JobSavedRepository extends JpaRepository<JobSaved, Long> {
	List<JobSaved> findByApplicant(Applicant applicant);
}

