package com.springmvc.vietjob.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springmvc.vietjob.model.Job;
import com.springmvc.vietjob.model.Enterprise;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

	List<Job> findAllByEnterprise(Enterprise enterprise, Sort sort);
	
	// Count Job per month by year
	@Query("SELECT COUNT(startDate) FROM Job WHERE Month(startDate) = :month AND Year(startDate) = :year")
	long countJobByMonthAndYear(@Param("month") int month,@Param("year") int year);
	
	// Top 5 Jobs have the highest number of candidates
	@Query(value = "select cv.id, cv.tieu_de, ct.ten_cong_ty, count(tt.id_cong_viec) as ungviens from trangthaihoso tt\r\n"
			+ "inner join congviec cv\r\n"
			+ "on cv.id = tt.id_cong_viec\r\n"
			+ "inner join congty ct\r\n"
			+ "on ct.id = cv.id_cong_ty\r\n"
			+ "group by tt.id_cong_viec\r\n"
			+ "order by ungviens desc\r\n"
			+ "limit 5", nativeQuery = true)
	List<Object> topFiveJob();
	
	@Query("SELECT startDate FROM Job group by year(startDate)")
	List<Date> getYears();
	
	@Query("SELECT j FROM Job j "
			+ "WHERE CONCAT(j.title, ' ', j.enterprise.name) LIKE %?1%"
			+ "AND j.career.name LIKE %?2%"
			+ "AND j.province LIKE %?3%")
	List<Job> searchJob(String keyword, String career, String province);
}
