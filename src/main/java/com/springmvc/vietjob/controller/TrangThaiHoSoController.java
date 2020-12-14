package com.springmvc.vietjob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.vietjob.model.TrangThaiHoSo;
import com.springmvc.vietjob.repository.TrangThaiHoSoRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/trang-thai-ho-so")
public class TrangThaiHoSoController {
	
	@Autowired
	TrangThaiHoSoRepository trangThaiHoSoRepository;
	
	@GetMapping("/list")
	public List<TrangThaiHoSo> getTrangThaiHoSos() {
		return trangThaiHoSoRepository.findAll();
	}
	@GetMapping("/count")
	public long countTrangThaiHoSo() {
		return trangThaiHoSoRepository.count();
	}
	
	@GetMapping("/count-chap-thuan")
	public long countChapThuan() {
		return trangThaiHoSoRepository.countByTrangThai("Đã Chấp Thuận");
	}
	
	@GetMapping("/count-dang-cho")
	public long countDangCho() {
		return trangThaiHoSoRepository.countByTrangThai("Đang Chờ");
	}
	
	@GetMapping("/count-tu-choi")
	public long countTuChoi() {
		return trangThaiHoSoRepository.countByTrangThai("Bị Từ Chối");
	}
}
