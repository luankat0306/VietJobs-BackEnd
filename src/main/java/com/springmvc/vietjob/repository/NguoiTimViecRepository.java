package com.springmvc.vietjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.vietjob.model.NguoiTimViec;

@Repository
public interface NguoiTimViecRepository extends JpaRepository<NguoiTimViec, Long> {

}
