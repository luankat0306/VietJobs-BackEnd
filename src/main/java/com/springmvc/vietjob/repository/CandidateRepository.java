package com.springmvc.vietjob.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.vietjob.model.Candidate;
import com.springmvc.vietjob.model.Job;
import com.springmvc.vietjob.model.Resume;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	
	long countByStatus(String status);
	
	List<Candidate> findAllByResume(Resume resume);
	
	List<Candidate> findByStatus(String status);
	
	List<Candidate> findByResume(Resume resume);
	
	@Transactional
	void deleteAllByJob(Job job);
	
	List<Candidate> findAllByStatusAndJobIn(String status, List<Job> job);
	
	@Query("SELECT c.job.enterprise FROM Candidate AS c GROUP BY c.job.enterprise ORDER BY COUNT(c.resume) DESC")
	List<Object> findTop5CountResumeByJob(Pageable pageable);
}
