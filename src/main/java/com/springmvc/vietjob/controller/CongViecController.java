 package com.springmvc.vietjob.controller;

import java.time.LocalDate;
import java.util.ArrayList;
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
import com.springmvc.vietjob.model.CongViec;
import com.springmvc.vietjob.model.NhaTuyenDung;
import com.springmvc.vietjob.repository.CongViecRepository;
import com.springmvc.vietjob.repository.NhaTuyenDungRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/cong-viec")
public class CongViecController {
	
	@Autowired
	CongViecRepository congViecRepository;
	
	@Autowired
	NhaTuyenDungRepository nhaTuyenDungRepository;

	// List Jobs
	@GetMapping("/list")
	public List<CongViec> getJobs() {
		return congViecRepository.findAll();
	}
	// List Jobs Of Enterprise
	@GetMapping("/list/{id}")
	public List<CongViec> getJobsOfEnterprise (@PathVariable Long id) {
		NhaTuyenDung nhaTuyenDung = nhaTuyenDungRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy"));
		return congViecRepository.findAllByNhaTuyenDung(nhaTuyenDung);
	}
	
	@PostMapping("/create") 
	public CongViec createJob(@RequestBody CongViec congViec) {
		return congViecRepository.save(congViec);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CongViec> getJob(@PathVariable Long id) {
		CongViec congViec = congViecRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy id= " + id));
		return ResponseEntity.ok(congViec);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CongViec> updateJob(@PathVariable Long id, @RequestBody CongViec congViecForm) {
		CongViec congViec = congViecRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy id= " + id));
		
		congViecForm.setId(congViec.getId());
		
		CongViec updatedCongViec = congViecRepository.save(congViecForm);
		return ResponseEntity.ok(congViecRepository.save(updatedCongViec));
	}
	
	@DeleteMapping("/{id}/delete")
	public String deleteJob(@PathVariable Long id) {
		congViecRepository.deleteById(id);
		return "Delete Success";
	}
	
	@GetMapping("/count")
	public long countJob() {
		return congViecRepository.count();
	}
	
	@GetMapping("/list-count-monthly/{year}")
	public List<Long> countJobWithMonth(@PathVariable int year) {
		List<Long> dataList = new ArrayList<Long>();
		LocalDate dateNow = LocalDate.now();
		int monthInt;
		
		// Year Present
		if(year == dateNow.getYear()) {
			monthInt = dateNow.getMonthValue();
		}
		//Greater Year Present
		else if (year >= dateNow.getYear()) {
			monthInt = 0;
		}
		// Less Year Present
		else {
			monthInt = 12;
		}
		
		for (int i = 1; i <= monthInt; i++) {
			dataList.add(congViecRepository.countNgayDangByMonthAndYear(i, year));
		}
		
		return dataList;
	}
	
	@GetMapping("/chart/top-five-cong-ty")
	public List<Object> getTop5CongViec() {
		return congViecRepository.topFiveCongTy();
	}
	
	@GetMapping("/chart/top-five-cong-viec")
	public List<Object> getTop5CongTy() {
		return congViecRepository.topFiveCongViec();
	}
}
