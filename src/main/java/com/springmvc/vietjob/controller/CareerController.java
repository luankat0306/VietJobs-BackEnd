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
import com.springmvc.vietjob.model.Career;
import com.springmvc.vietjob.repository.CareerRepository;


@RestController
@RequestMapping("/api/careers")
public class CareerController {

	@Autowired
	CareerRepository careerRepository;
	
	@GetMapping
	public List<Career> getCareers() {
		return careerRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Career> getCareer(@PathVariable long id) {
		Career career = careerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy ngành nghề"));
		return ResponseEntity.ok(career);
	}
	
	@PostMapping
	public ResponseEntity<Career> createCareer(@RequestBody Career career) {
		return ResponseEntity.ok(careerRepository.save(career));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Career> updateCareer(@PathVariable Long id, @RequestBody Career careerForm) {
		Career career = careerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy id= " + id));
		
		careerForm.setId(career.getId());
		
		Career updatedCareer = careerRepository.save(careerForm);
		return ResponseEntity.ok(updatedCareer);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCareer(@PathVariable Long id) {
		careerRepository.deleteById(id);
		
		return ResponseEntity.ok("Xóa thành công");
	}
	
	@GetMapping("/search/{keyword}")
	public List<Career> search(@PathVariable String keyword) {
		return careerRepository.search(keyword);
	}
}
