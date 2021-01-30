package com.springmvc.vietjob.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.vietjob.model.UserHasRole;

@Repository
public interface UserHasRoleRepository extends JpaRepository<UserHasRole, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM user_has_role WHERE user_id = ?1", nativeQuery = true)
	void deleteByRoles(Long user_id);
}
