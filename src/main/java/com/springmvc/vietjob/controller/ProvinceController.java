package com.springmvc.vietjob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.vietjob.model.Province;
import com.springmvc.vietjob.repository.ProvinceRepository;

@RestController
@RequestMapping("/api/provinces")
public class ProvinceController {

	@Autowired
	ProvinceRepository provinceRepository;
	
	@GetMapping
	public List<Province> getProvinces() {
		return provinceRepository.findAll();
	}
}
