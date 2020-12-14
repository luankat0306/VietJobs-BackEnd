package com.springmvc.vietjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.vietjob.model.TrangThaiHoSo;

public interface TrangThaiHoSoRepository extends JpaRepository<TrangThaiHoSo, Long> {
	
	long countByTrangThai(String trangThai);
}
