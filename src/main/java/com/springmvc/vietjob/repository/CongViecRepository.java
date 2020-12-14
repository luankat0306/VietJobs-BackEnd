package com.springmvc.vietjob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springmvc.vietjob.model.CongViec;
import com.springmvc.vietjob.model.NhaTuyenDung;

public interface CongViecRepository extends JpaRepository<CongViec, Long> {

	List<CongViec> findAllByNhaTuyenDung(NhaTuyenDung nhaTuyenDung);
	
	@Query("SELECT COUNT(ngayDang) FROM CongViec WHERE Month(ngayDang) = :month AND Year(ngayDang) = :year")
	long countNgayDangByMonthAndYear(@Param("month") int month,@Param("year") int year);
	
	@Query(value = "select cv.id_cong_ty, ct.ten_cong_ty, count(cv.id_cong_ty) as congviecs from congviec cv \r\n"
			+ "inner join congty ct \r\n"
			+ "on ct.id = cv.id_cong_ty\r\n"
			+ "group by ct.id, ct.ten_cong_ty\r\n"
			+ "order by congviecs desc\r\n"
			+ "limit 5", nativeQuery = true)
	List<Object> topFiveCongTy();
	
	@Query(value = "select cv.id, cv.tieu_de, ct.ten_cong_ty, count(tt.id_cong_viec) as ungviens from trangthaihoso tt\r\n"
			+ "inner join congviec cv\r\n"
			+ "on cv.id = tt.id_cong_viec\r\n"
			+ "inner join congty ct\r\n"
			+ "on ct.id = cv.id_cong_ty\r\n"
			+ "group by tt.id_cong_viec\r\n"
			+ "order by ungviens desc\r\n"
			+ "limit 5", nativeQuery = true)
	List<Object> topFiveCongViec();
}
