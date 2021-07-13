package com.springmvc.vietjob.controller;

import com.springmvc.vietjob.exception.ResourceNotFoundException;
import com.springmvc.vietjob.model.Applicant;
import com.springmvc.vietjob.model.User;
import com.springmvc.vietjob.payload.request.ChangeSocialLink;
import com.springmvc.vietjob.payload.response.MessageResponse;
import com.springmvc.vietjob.repository.ApplicantRepository;
import com.springmvc.vietjob.repository.RoleRepository;
import com.springmvc.vietjob.repository.UserHasRoleRepository;
import com.springmvc.vietjob.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // Danh sách người tìm việc
    @GetMapping
    public List<Applicant> getApplicants() {
        return applicantRepository.findAll();
    }


    // Lấy người tìm việc
    @GetMapping("/{id}")
    public ResponseEntity<Applicant> getApplicant(@PathVariable Long id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
        return ResponseEntity.ok(applicant);
    }

    // Lấy người tìm việc từ id user
    @GetMapping("/users/{id}")
    public ResponseEntity<Applicant> getApplicantByUserId(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
        Applicant applicant = applicantRepository.findByUser(user);

        return ResponseEntity.ok(applicant);
    }

    // Thay đổi thông tin người tìm việc
    @PutMapping("/{id}")
    public ResponseEntity<?> updateApplicant(@PathVariable Long id, @RequestBody Applicant applicantForm) {

        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));

        applicant.setAddress(applicantForm.getAddress());
        applicant.setBirthday(applicantForm.getBirthday());
        applicant.setGender(applicantForm.getGender());
        applicant.setProvince(applicantForm.getProvince());

        User userForm = applicantForm.getUser();
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
        applicant.setUser(createdUser);

        Applicant updatedApplicant = applicantRepository.save(applicant);
        return ResponseEntity.ok(updatedApplicant);
    }

    // Xóa người tìm việc
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplicant(@PathVariable Long id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại"));
        userHasRoleRepository.deleteByRoles(applicant.getUser().getId());

        applicantRepository.deleteById(id);

        userRepository.deleteById(applicant.getUser().getId());


        return ResponseEntity.ok("Delete Success");
    }

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
