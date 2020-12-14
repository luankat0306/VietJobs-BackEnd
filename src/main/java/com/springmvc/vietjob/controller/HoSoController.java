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
import com.springmvc.vietjob.model.HoSo;
import com.springmvc.vietjob.repository.HoSoRepository;

@RestController
@RequestMapping("/api")
public class HoSoController {

	@Autowired
	HoSoRepository hoSoRepository;
	
	@GetMapping("/ho-so/list")
	public List<HoSo> getHoSos() {
		return hoSoRepository.findAll();
	}
	
	@PostMapping("/ho-so/create")
	public HoSo createHoSo(@RequestBody HoSo hoSo) {
		return hoSoRepository.save(hoSo);
	}
	
	@GetMapping("/ho-so/{id}")
	public ResponseEntity<HoSo> getHoSo (@PathVariable Long id) {
		HoSo hoSo = hoSoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hồ sơ không tồn tại"));
		return ResponseEntity.ok(hoSo);
	}
	
	@PutMapping("/ho-so/{id}/update")
	public ResponseEntity<HoSo> updateHoSo(@PathVariable Long id, @RequestBody HoSo hoSoForm) {
		HoSo hoSo = hoSoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Hồ sơ không tồn tại"));
		
		hoSo.setId(hoSoForm.getId());
		
		HoSo hoSoUpdated = hoSoRepository.save(hoSo);
		return ResponseEntity.ok(hoSoUpdated);
	}
	
	@DeleteMapping("/ho-so/{id}/delete")
	public String deleteHoSo(@PathVariable Long id) {
		hoSoRepository.deleteById(id);
		return "Delete Success";
	}
}
