package com.springmvc.vietjob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.vietjob.exception.ResourceNotFoundException;
import com.springmvc.vietjob.model.User;
import com.springmvc.vietjob.payload.request.ChangeEmail;
import com.springmvc.vietjob.payload.request.ChangePassword;
import com.springmvc.vietjob.payload.response.MessageResponse;
import com.springmvc.vietjob.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
 		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/change-password/{id}")
	public ResponseEntity<?> changePassword(@PathVariable Long id, @RequestBody ChangePassword passwordForm) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String passwordEncode = passwordEncoder.encode(passwordForm.getPassword());
		
		if(!encoder.matches(passwordForm.getCurrentPassword(), user.getPassword())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Mật khẩu hiện tại không đúng"));
		}
		
		user.setPassword(passwordEncode);
		userRepository.save(user);
		return ResponseEntity.ok("Đổi mật khẩu thành công");
		
	}
	
	@PostMapping("/change-email/{id}")
	public ResponseEntity<?> changeEmail(@PathVariable Long id, @RequestBody ChangeEmail emailForm) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		//Kiểm tra username đã tồn tại
		if(!encoder.matches(emailForm.getConfirmPassword(), user.getPassword())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Mật khẩu hiện tại không đúng"));
		}

		//Kiểm tra email đã tồn tại
		if (userRepository.existsByEmail(emailForm.getEmail()) && 
				user.getEmail().equals(emailForm.getEmail())) {
			
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email đã tồn tại"));
		}
		
		user.setEmail(emailForm.getEmail());
		userRepository.save(user);
		return ResponseEntity.ok("Đổi Email thành công");
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userForm) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
		
 		user.setEmail(userForm.getEmail());
 		user.setFullname(userForm.getFullname());
 		user.setImage(userForm.getImage());
 		user.setPassword(userForm.getPassword());
 		user.setPhone(userForm.getPhone());
 		user.setUsername(userForm.getUsername());
 		
 		User updatedUser = userRepository.save(user);
 		return ResponseEntity.ok(updatedUser);
	}
}