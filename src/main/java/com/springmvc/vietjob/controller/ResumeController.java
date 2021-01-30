package com.springmvc.vietjob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.vietjob.exception.ResourceNotFoundException;
import com.springmvc.vietjob.model.Applicant;
import com.springmvc.vietjob.model.Resume;
import com.springmvc.vietjob.repository.ApplicantRepository;
import com.springmvc.vietjob.repository.ResumeRepository;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

	@Autowired
	ResumeRepository resumeRepository;
	
	@Autowired
	ApplicantRepository applicantRepository;
	@GetMapping
	public List<Resume> getResumes() {
		return resumeRepository.findAll();
	}
	
	@PostMapping
	public Resume createResume(@RequestBody Resume hoSo) {
		return resumeRepository.save(hoSo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Resume> getResume (@PathVariable Long id) {
		Resume hoSo = resumeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hồ sơ không tồn tại"));
		return ResponseEntity.ok(hoSo);
	}
	
	@GetMapping("/applicants/{id}")
	public ResponseEntity<Resume> getResumeByApplicant (@PathVariable Long id) {
		Applicant applicant = applicantRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy"));
		
		Resume hoSo = resumeRepository.findByApplicant(applicant)
				.orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy"));
		return ResponseEntity.ok(hoSo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Resume> updateResume(@PathVariable Long id, @RequestBody Resume hoSoForm) {
		Resume hoSo = resumeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hồ sơ không tồn tại"));
		
		hoSo.setApplicant(hoSoForm.getApplicant());
		hoSo.setCareer(hoSoForm.getCareer());
		hoSo.setDesiredVacancy(hoSoForm.getDesiredVacancy());
		hoSo.setEducation(hoSoForm.getEducation());
		hoSo.setExperience(hoSoForm.getExperience());
		hoSo.setForeignLanguage(hoSoForm.getForeignLanguage());
		hoSo.setJobType(hoSoForm.getJobType());
		hoSo.setWage(hoSoForm.getWage());
		
		Resume hoSoUpdated = resumeRepository.save(hoSo);
		return ResponseEntity.ok(hoSoUpdated);
	}
	
	@DeleteMapping("/{id}")
	public String deleteResume(@PathVariable Long id) {
		resumeRepository.deleteById(id);
		return "Delete Success";
	}
}
