package com.springmvc.vietjob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.vietjob.exception.ResourceNotFoundException;
import com.springmvc.vietjob.model.Applicant;
import com.springmvc.vietjob.model.JobSaved;
import com.springmvc.vietjob.repository.ApplicantRepository;
import com.springmvc.vietjob.repository.JobSavedRepository;

@RestController
@RequestMapping("/api/jobsaveds")
public class JobSavedController {
	
	@Autowired
	JobSavedRepository jobSavedRepository;
	
	@Autowired
	ApplicantRepository applicantRepository;
	
	@GetMapping("/{idApplicant}")
	public ResponseEntity<List<JobSaved>> getJobSaveds(@PathVariable Long idApplicant) {
		Applicant applicant = applicantRepository.findById(idApplicant)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		
		return ResponseEntity.ok(jobSavedRepository.findByApplicant(applicant));
	}
	
	@PostMapping
	public ResponseEntity<?> saveJob(@RequestBody JobSaved jobSaved) {
		
		jobSaved.setSaved("Lưu");
		return ResponseEntity.ok(jobSavedRepository.save(jobSaved));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteJobSaved(@PathVariable Long id) {
		jobSavedRepository.deleteById(id);
		
		return ResponseEntity.ok("Xóa Thành Công");
	}
}
