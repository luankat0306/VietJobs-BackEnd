package com.springmvc.vietjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.vietjob.model.NhaTuyenDung;

@Repository
public interface NhaTuyenDungRepository extends JpaRepository<NhaTuyenDung, Long> {

}