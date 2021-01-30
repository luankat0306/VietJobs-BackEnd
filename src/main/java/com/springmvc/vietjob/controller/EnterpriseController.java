package com.springmvc.vietjob.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.vietjob.exception.ResourceNotFoundException;
import com.springmvc.vietjob.model.Enterprise;
import com.springmvc.vietjob.model.EnumRole;
import com.springmvc.vietjob.model.Role;
import com.springmvc.vietjob.model.User;
import com.springmvc.vietjob.payload.response.MessageResponse;
import com.springmvc.vietjob.repository.EnterpriseRepository;
import com.springmvc.vietjob.repository.RoleRepository;
import com.springmvc.vietjob.repository.UserHasRoleRepository;
import com.springmvc.vietjob.repository.UserRepository;

@RestController
@RequestMapping("/api/enterprises")
public class EnterpriseController {
	
	@Autowired
	EnterpriseRepository enterpriseRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserHasRoleRepository userHasRoleRepository;
	
	@GetMapping
	public List<Enterprise> getEnterprises() {
		return enterpriseRepository.findAll();
	}
	
	// Get enterprise
	@GetMapping("/{id}")
	public ResponseEntity<Enterprise> getEnterprise(@PathVariable Long id) {
 		Enterprise enterprise = enterpriseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		return ResponseEntity.ok(enterprise);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Enterprise> getEnterpriseByUser(@PathVariable Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		
 		Enterprise enterprise = enterpriseRepository.findByUser(user);
				
		return ResponseEntity.ok(enterprise);
	}
	
	// Create Enterprise
	@PostMapping("/signup")
	public  ResponseEntity<?> createEnterprise(@RequestBody Enterprise enterprise) {
		Set<Role> roles = new HashSet<>();
		
		if (userRepository.existsByUsername(enterprise.getUser().getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Username đã tồn tại!"));
		}

		if (userRepository.existsByEmail(enterprise.getUser().getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Email đã tồn tại!"));
		}

		Role userRole = roleRepository.findByName(EnumRole.ROLE_ENTERPRISE)
				.orElseThrow(() -> new RuntimeException("Không tìm thấy Role"));
				
		roles.add(userRole);
		/*	
		 * CREATE USER BEFORE CREATE ENTERPRISE
		 */
		User user = enterprise.getUser();
		user.setRoles(roles);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setImage("default.png");
		
		User createdUser = userRepository.save(user);	
		enterprise.setUser(createdUser);

		return ResponseEntity.ok(enterpriseRepository.save(enterprise));
	}
	
	// Update Enterprise
	@PutMapping("/{id}")
	public ResponseEntity<?> updateEnterprise(@PathVariable Long id, @RequestBody Enterprise enterpriseForm) {
//			Find enterprise by path id
		Enterprise enterprise = enterpriseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
//			set enterprise applicantForm for the applicant above
		enterprise.setAddress(enterpriseForm.getAddress());
		enterprise.setContact(enterpriseForm.getContact());
		enterprise.setDescription(enterpriseForm.getDescription());
		enterprise.setWebsite(enterpriseForm.getWebsite());
		enterprise.setName(enterpriseForm.getName());
		
		User userForm = enterpriseForm.getUser();
		User user = userRepository.findById(userForm.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		
		if(!userForm.getUsername().equals(user.getUsername())) {
			if (userRepository.existsByUsername(userForm.getUsername())) {
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse("Username đã tồn tại!"));
			}
		}

		if(!userForm.getEmail().equals(user.getEmail())) {
			if (userRepository.existsByEmail(userForm.getEmail())) {
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse("Email đã tồn tại!"));
			}
		}
//			set property userForm for the user above
		user.setEmail(userForm.getEmail());
		user.setFullname(userForm.getFullname());
		user.setPhone(userForm.getPhone());
		user.setUsername(userForm.getUsername());
		
		User createdUser = userRepository.save(user);
		enterprise.setUser(createdUser);
		
		Enterprise updatedEnterprise = enterpriseRepository.save(enterprise);
		return ResponseEntity.ok(updatedEnterprise);
	}
	
	// Delete Applicant
	@DeleteMapping("/{id}")
	public  ResponseEntity<?> deleteApplicant(@PathVariable Long id) {
		try {
			Enterprise enterprise = enterpriseRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
				userHasRoleRepository.deleteByRoles(enterprise.getUser().getId());
				
				enterpriseRepository.deleteById(id);
				
				userRepository.deleteById(enterprise.getUser().getId());
					
				return ResponseEntity.ok("Delete Success");
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Không thể xóa công ty này"));
		}
		
	}
	
	@GetMapping("/count")
	public long countEnterprise() {
		return enterpriseRepository.count();
	}
	
	@GetMapping("/chart/top-five-enterprises")
	public List<Object> topFiveEnterprise() {
		return enterpriseRepository.topFiveEnterprise();
	}
	
	@PostMapping("/change-description/{id}")
	public ResponseEntity<?> changeDescription(@PathVariable Long id, @RequestBody Enterprise enterpriseForm) {
		Enterprise enterprise = enterpriseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		
		enterprise.setDescription(enterpriseForm.getDescription());
		
		return ResponseEntity.ok(enterpriseRepository.save(enterprise));
	}
	
	@GetMapping("/search/{keyword}")
	public List<Enterprise> search(@PathVariable String keyword) {
		return enterpriseRepository.search(keyword);
	}
}
