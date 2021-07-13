package com.springmvc.vietjob.controller;

import com.springmvc.vietjob.exception.ResourceNotFoundException;
import com.springmvc.vietjob.model.Enterprise;
import com.springmvc.vietjob.model.User;
import com.springmvc.vietjob.payload.response.MessageResponse;
import com.springmvc.vietjob.repository.EnterpriseRepository;
import com.springmvc.vietjob.repository.RoleRepository;
import com.springmvc.vietjob.repository.UserHasRoleRepository;
import com.springmvc.vietjob.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //Danh sách nhà tuyển dụng
    @GetMapping
    public List<Enterprise> getEnterprises() {
        return enterpriseRepository.findAll();
    }

    // Lấy nhà tuyển dụng
    @GetMapping("/{id}")
    public ResponseEntity<Enterprise> getEnterprise(@PathVariable Long id) {
        Enterprise enterprise = enterpriseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
        return ResponseEntity.ok(enterprise);
    }

    //Lấy nhà tuyển dụng từ id user
    @GetMapping("/users/{id}")
    public ResponseEntity<Enterprise> getEnterpriseByUser(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));

        Enterprise enterprise = enterpriseRepository.findByUser(user);

        return ResponseEntity.ok(enterprise);
    }

    //Thay đổi thông tin nhà tuyển dụng
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEnterprise(@PathVariable Long id, @RequestBody Enterprise enterpriseForm) {

        //Set thuộc tính enterpriseForm vào enterprise
        Enterprise enterprise = enterpriseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));

        enterprise.setAddress(enterpriseForm.getAddress());
        enterprise.setContact(enterpriseForm.getContact());
        enterprise.setDescription(enterpriseForm.getDescription());
        enterprise.setWebsite(enterpriseForm.getWebsite());
        enterprise.setName(enterpriseForm.getName());

        User userForm = enterpriseForm.getUser();
        User user = userRepository.findById(userForm.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));

        //Kiểm tra username đã tồn tại
        if (!userForm.getUsername().equals(user.getUsername())) {
            if (userRepository.existsByUsername(userForm.getUsername())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Username đã tồn tại!"));
            }
        }

        //Kiểm tra email đã tồn tại
        if (!userForm.getEmail().equals(user.getEmail())) {
            if (userRepository.existsByEmail(userForm.getEmail())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Email đã tồn tại!"));
            }
        }

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
    public ResponseEntity<?> deleteApplicant(@PathVariable Long id) {
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
