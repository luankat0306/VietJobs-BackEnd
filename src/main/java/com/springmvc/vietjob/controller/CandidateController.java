package com.springmvc.vietjob.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
import com.springmvc.vietjob.model.Candidate;
import com.springmvc.vietjob.model.Enterprise;
import com.springmvc.vietjob.model.Job;
import com.springmvc.vietjob.model.Resume;
import com.springmvc.vietjob.payload.response.MessageResponse;
import com.springmvc.vietjob.repository.CandidateRepository;
import com.springmvc.vietjob.repository.EnterpriseRepository;
import com.springmvc.vietjob.repository.JobRepository;
import com.springmvc.vietjob.repository.ResumeRepository;


@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
	
	@Autowired
	CandidateRepository candidateRepository;
	
	@Autowired
	ResumeRepository resumeRepository;
	
	@Autowired
	JobRepository jobRepository;
	
	@Autowired
	EnterpriseRepository enterpriseRepository;
	
	@GetMapping
	public List<Candidate> getCandidates() {
		return candidateRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Candidate> getCandidate(@PathVariable Long id) {
		Candidate candidate = candidateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		
		return ResponseEntity.ok(candidate);
	}
	@GetMapping("/resumes/{id}")
	public ResponseEntity<List<Candidate>> getCandidatesByResume(@PathVariable Long id) {
		Resume resume = resumeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		
		return ResponseEntity.ok(candidateRepository.findAllByResume(resume));
	}
	
	@GetMapping("/jobs/enterprises/{id}")
	public ResponseEntity<List<Candidate>> getCandidatesByEnterprise(@PathVariable Long id) {
		Enterprise enterprise = enterpriseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		
		List<Job> jobs = jobRepository.findAllByEnterprise(enterprise, Sort.by("startDate").descending());
			
		return ResponseEntity.ok(candidateRepository.findAllByStatusAndJobIn("Đang Chờ", jobs));
	}
	
	@GetMapping("/jobs/enterprises/{id}/accept")
	public ResponseEntity<List<Candidate>> getCandidatesAccept(@PathVariable Long id) {
		Enterprise enterprise = enterpriseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		
		
		List<Job> jobs = jobRepository.findAllByEnterprise(enterprise, Sort.by("startDate").descending());
		

		
		return ResponseEntity.ok(candidateRepository.findAllByStatusAndJobIn("Đã Chấp Thuận", jobs));
	}
	
	@PostMapping
	public ResponseEntity<?> createCandidate(@RequestBody Candidate candidate) {
		
		Job job = jobRepository.findById(candidate.getJob().getId())
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		
		LocalDate dateNow = LocalDate.now();	
		Date date = java.sql.Date.valueOf(dateNow);
		
		if(job.getEndDate().before(date)) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Bài đăng tuyển này đã hết hạn nộp")); 
		}
		candidate.setStatus("Đang Chờ");
		return ResponseEntity.ok(candidateRepository.save(candidate));
	}
	
	@PutMapping("/accept/{id}")
	public ResponseEntity<Candidate> acceptCandidate(@PathVariable Long id) {
		
		Candidate candidate = candidateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		
		candidate.setStatus("Đã Chấp Thuận");
		return ResponseEntity.ok(candidateRepository.save(candidate));
	}
	
	@PutMapping("/reject/{id}")
	public ResponseEntity<Candidate> rejectCandidate(@PathVariable Long id) {
		
		Candidate candidate = candidateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
					
		candidate.setStatus("Bị Từ Chối");
		return ResponseEntity.ok(candidateRepository.save(candidate));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCandidate(@PathVariable Long id) {
		candidateRepository.deleteById(id);
		return ResponseEntity.ok("Xoá thành công");
	}
	@GetMapping("/count")
	public long countCandidate() {
		return candidateRepository.count();
	}
	
	@GetMapping("/count-chap-thuan")
	public long countChapThuan() {
		return candidateRepository.countByStatus("Đã Chấp Thuận");
	}
	
	@GetMapping("/count-dang-cho")
	public long countDangCho() {
		return candidateRepository.countByStatus("Đang Chờ");
	}
	
	@GetMapping("/count-tu-choi")
	public long countTuChoi() {
		return candidateRepository.countByStatus("Bị Từ Chối");
	}
	
	@GetMapping("/top5")
	public List<Object> top5() {
		return candidateRepository.findTop5CountResumeByJob(PageRequest.of(0, 6));
	}
}
