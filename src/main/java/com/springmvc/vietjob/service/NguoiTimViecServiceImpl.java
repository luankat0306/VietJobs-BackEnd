package com.springmvc.vietjob.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.vietjob.model.NguoiTimViec;
import com.springmvc.vietjob.repository.NguoiTimViecRepository;

@Service
public class NguoiTimViecServiceImpl implements NguoiTimViecService {

	@Autowired
	private NguoiTimViecRepository nguoiTimViecRepository;

	@Override
	public List<NguoiTimViec> getNguoiTimViecs() {
		return nguoiTimViecRepository.findAll();
	}

	/*
	 * @Override
	 * 
	 * public NguoiTimViec getNguoiTimViec(Long id) {
	 * 
	 * Optional<NguoiTimViec> optional = nguoiTimViecRepository.findById(id); return
	 * ; }
	 * 
	 * @Override public Optional<NguoiTimViec> deleteNguoiTimViec(Long id) { // TODO
	 * Auto-generated method stub return nguoiTimViecRepository.deleteById(id); }
	 * 
	 * @Override public void saveNguoiTimViec(NguoiTimViec nguoiTimViec) { // TODO
	 * Auto-generated method stub this.nguoiTimViecRepository.save(nguoiTimViec); }
	 * 
	 * 
	 * @Override public NguoiTimViec getNguoiTimViec(long id) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public NguoiTimViec deleteNguoiTimViec(long id) { // TODO
	 * Auto-generated method stub return null; }
	 */
}
