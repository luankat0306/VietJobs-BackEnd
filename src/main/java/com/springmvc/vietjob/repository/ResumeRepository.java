package com.springmvc.vietjob.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.vietjob.model.Applicant;
import com.springmvc.vietjob.model.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long>{
	Optional<Resume> findByApplicant(Applicant applicant);
}
