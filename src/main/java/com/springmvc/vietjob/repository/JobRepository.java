package com.springmvc.vietjob.repository;

import com.springmvc.vietjob.model.Career;
import com.springmvc.vietjob.model.Enterprise;
import com.springmvc.vietjob.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    Page<Job> findAll(Pageable pageable);

    List<Job> findAllByEnterprise(Enterprise enterprise, Sort sort);

    List<Job> findAllByCareerAndIdNot(Career career, Long id);

    // Count Job per month by year
    @Query(value = "SELECT COUNT(startDate) FROM Job WHERE FUNCTION('Month',startDate) = :month AND FUNCTION('Year',startDate) = :year")
    long countJobByMonthAndYear(@Param("month") int month, @Param("year") int year);

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

    @Query(value = "select *, count(tt.id_cong_viec) as ungviens from vietjobs.congviec cv \r\n"
            + "inner join vietjobs.trangthaihoso tt \r\n"
            + "on cv.id = tt.id_cong_viec\r\n"
            + "inner join vietjobs.congty ct\r\n"
            + "on ct.id = cv.id_cong_ty\r\n"
            + "group by cv.id\r\n"
            + "order by ungviens desc;",
             nativeQuery = true)
    Page<Job> findAllJobsPopular(Pageable pageable);

    @Query("SELECT startDate FROM Job group by FUNCTION('YEAR',startDate)")
    List<Date> getYears();

    @Query("SELECT j FROM Job j "
            + "WHERE CONCAT(j.title, ' ', j.enterprise.name) LIKE %?1%"
            + "AND j.career.name LIKE %?2%"
            + "AND j.province LIKE %?3%")
    Page<Job> searchJob(String keyword, String career, String province, Pageable pageable);
}
