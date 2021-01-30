package com.springmvc.vietjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.vietjob.model.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long>{

}
