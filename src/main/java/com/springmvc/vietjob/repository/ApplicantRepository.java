package com.springmvc.vietjob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.vietjob.model.Applicant;
import com.springmvc.vietjob.model.User;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
	Applicant findByUser(User user);
	
	@Query("SELECT a FROM Applicant a WHERE CONCAT(a.user.fullname, ' ', a.user.phone, ' ', a.user.email) LIKE %?1%")
	List<Applicant> search(String keyword);
}
