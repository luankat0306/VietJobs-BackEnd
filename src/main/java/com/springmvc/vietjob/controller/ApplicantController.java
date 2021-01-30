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
import com.springmvc.vietjob.model.Applicant;
import com.springmvc.vietjob.model.EnumRole;
import com.springmvc.vietjob.model.Role;
import com.springmvc.vietjob.model.User;
import com.springmvc.vietjob.payload.request.ChangeSocialLink;
import com.springmvc.vietjob.payload.response.MessageResponse;
import com.springmvc.vietjob.repository.ApplicantRepository;
import com.springmvc.vietjob.repository.RoleRepository;
import com.springmvc.vietjob.repository.UserHasRoleRepository;
import com.springmvc.vietjob.repository.UserRepository;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {
	
	@Autowired
	ApplicantRepository applicantRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserHasRoleRepository userHasRoleRepository;
	// List Applicants
	@GetMapping
	public List<Applicant> getApplicants() {
		return applicantRepository.findAll();
	}
	
	// Create Applicant
	@PostMapping("/signup")
	public  ResponseEntity<?> createApplicant(@RequestBody Applicant applicant) {
		Set<Role> roles = new HashSet<>();
		
		if (userRepository.existsByUsername(applicant.getUser().getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Username đã tồn tại!"));
		}

		if (userRepository.existsByEmail(applicant.getUser().getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Email đã tồn tại!"));
		}

		Role userRole = roleRepository.findByName(EnumRole.ROLE_USER)
				.orElseThrow(() -> new RuntimeException("Không tìm tấy Role"));;
				
		roles.add(userRole);
		/*
		 * CREATE USER BEFORE CREATE APPLICANT
		 */
		User user = applicant.getUser();
		user.setRoles(roles);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setImage("default.png");
		
		User createdUser = userRepository.save(user);	
		applicant.setUser(createdUser);

		return ResponseEntity.ok(applicantRepository.save(applicant));
	}
	
	// Get Applicant
	@GetMapping("/{id}")
	public ResponseEntity<Applicant> getApplicant(@PathVariable Long id) {
 		Applicant applicant = applicantRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		return ResponseEntity.ok(applicant);
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<Applicant> getApplicantByUserId(@PathVariable Long id) {
 		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
 		Applicant applicant = applicantRepository.findByUser(user);
 		
		return ResponseEntity.ok(applicant);
	}
	// Update Applicant
	@PutMapping("/{id}")
	public ResponseEntity<?> updateApplicant(@PathVariable Long id, @RequestBody Applicant applicantForm) {
//		Find applicant by path id
		Applicant applicant = applicantRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
//		set property applicantForm for the applicant above
		applicant.setAddress(applicantForm.getAddress());
		applicant.setBirthday(applicantForm.getBirthday());
		applicant.setGender(applicantForm.getGender());
		applicant.setProvince(applicantForm.getProvince());

		User userForm = applicantForm.getUser();
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
		
//		set property userForm for the user above
		user.setEmail(userForm.getEmail());
		user.setFullname(userForm.getFullname());
		user.setPhone(userForm.getPhone());
		user.setUsername(userForm.getUsername());
		
		User createdUser = userRepository.save(user);
		applicant.setUser(createdUser);
		
		Applicant updatedApplicant = applicantRepository.save(applicant);
		return ResponseEntity.ok(updatedApplicant);
	}
	
	// Delete Applicant
	@DeleteMapping("/{id}")
	public  ResponseEntity<String> deleteApplicant(@PathVariable Long id) {
		Applicant applicant = applicantRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		userHasRoleRepository.deleteByRoles(applicant.getUser().getId());
		
		applicantRepository.deleteById(id);
		
		userRepository.deleteById(applicant.getUser().getId());
		

		
		return ResponseEntity.ok("Delete Success");
	}
	
	//Count Applicant
	@GetMapping("/count")
	public long countApplicant() {
		return applicantRepository.count();
	}
	
	@PostMapping("change-social/{id}")
	public ResponseEntity<?> changeSocial(@PathVariable Long id, @RequestBody ChangeSocialLink changeSocialLink) {
		Applicant applicant = applicantRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		
		applicant.setFb(changeSocialLink.getFb());
		applicant.setIg(changeSocialLink.getIg());
		
		applicantRepository.save(applicant);
		
		return ResponseEntity.ok(applicant);
	}
	
	@GetMapping("/search/{keyword}")
	public List<Applicant> search(@PathVariable String keyword) {
		return applicantRepository.search(keyword);
	}
}
