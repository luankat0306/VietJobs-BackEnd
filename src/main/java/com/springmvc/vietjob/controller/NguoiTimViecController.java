package com.springmvc.vietjob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.vietjob.exception.ResourceNotFoundException;
import com.springmvc.vietjob.model.NguoiTimViec;
import com.springmvc.vietjob.repository.NguoiTimViecRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/nguoi-tim-viec")
public class NguoiTimViecController {
	
	@Autowired
	NguoiTimViecRepository nguoiTimViecRepository;
	// List Applicants
	@GetMapping("/list")
	public List<NguoiTimViec> getNguoiTimViecs() {
		return nguoiTimViecRepository.findAll();
	}
	// Create Applicant
	@PostMapping("/save")
	public  NguoiTimViec createNguoiTimViecs(@RequestBody NguoiTimViec user) {
		return nguoiTimViecRepository.save(user);
	}
	// Get @id Applicant
	@GetMapping("/{id}")
	public ResponseEntity<NguoiTimViec> getNguoiTimViec(@PathVariable Long id) {
		NguoiTimViec nguoiTimViec = nguoiTimViecRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		return ResponseEntity.ok(nguoiTimViec);
	}
	// Update Applicant
	@PutMapping("/{id}")
	public ResponseEntity<NguoiTimViec> updateNguoiTimViec(@PathVariable Long id, @RequestBody NguoiTimViec nguoiTimViecForm) {
		NguoiTimViec nguoiTimViec = nguoiTimViecRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		
		nguoiTimViecForm.setId(nguoiTimViec.getId());
		
		NguoiTimViec updatedNguoiTimViec = nguoiTimViecRepository.save(nguoiTimViecForm);
		return ResponseEntity.ok(updatedNguoiTimViec);
	}
	// Delete Applicant
	@DeleteMapping("/{id}")
	public  String deleteNguoiTimViec(@PathVariable Long id) {
		nguoiTimViecRepository.deleteById(id);
		return "Delete Success";
	}
	
	@GetMapping("/count")
	public long countNguoiTimViec() {
		return nguoiTimViecRepository.count();
	}
}
