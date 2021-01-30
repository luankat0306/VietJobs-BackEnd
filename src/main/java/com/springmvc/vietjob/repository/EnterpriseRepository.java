package com.springmvc.vietjob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.vietjob.model.Enterprise;
import com.springmvc.vietjob.model.User;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {

	@Query(value = "select cv.id_cong_ty, ct.ten_cong_ty, count(cv.id_cong_ty) as congviecs from congviec cv \r\n"
			+ "inner join congty ct \r\n"
			+ "on ct.id = cv.id_cong_ty\r\n"
			+ "group by ct.id, ct.ten_cong_ty\r\n"
			+ "order by congviecs desc\r\n"
			+ "limit 5", nativeQuery = true)
	List<Object> topFiveEnterprise();

	Enterprise findByUser(User user);
	
	@Query("SELECT e FROM Enterprise e WHERE CONCAT(e.name, ' ', e.user.phone, ' ', e.user.email) LIKE %?1%")
	List<Enterprise> search(String keyword);
}