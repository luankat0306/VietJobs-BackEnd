package com.springmvc.vietjob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.vietjob.model.Career;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {

	@Query("SELECT c FROM Career c WHERE c.name LIKE %?1%")
	List<Career> search(String keyword);
}
