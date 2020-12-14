package com.springmvc.vietjob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.vietjob.model.NhaTuyenDung;
import com.springmvc.vietjob.repository.NhaTuyenDungRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/nha-tuyen-dung")
public class NhaTuyenDungController {
	
	@Autowired
	NhaTuyenDungRepository nhaTuyenDungRepository;
	
	@GetMapping("/list")
	public List<NhaTuyenDung> getNhaTuyenDungs() {
		return nhaTuyenDungRepository.findAll();
	}
	
	@GetMapping("/count")
	public long countNhaTuyenDung() {
		return nhaTuyenDungRepository.count();
	}
}
