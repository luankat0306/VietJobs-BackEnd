package com.springmvc.vietjob.controller;

import com.springmvc.vietjob.model.*;
import com.springmvc.vietjob.payload.request.LoginRequest;
import com.springmvc.vietjob.payload.response.JwtResponse;
import com.springmvc.vietjob.payload.response.MessageResponse;
import com.springmvc.vietjob.repository.ApplicantRepository;
import com.springmvc.vietjob.repository.EnterpriseRepository;
import com.springmvc.vietjob.repository.RoleRepository;
import com.springmvc.vietjob.repository.UserRepository;
import com.springmvc.vietjob.security.jwt.JwtUtils;
import com.springmvc.vietjob.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ApplicantRepository applicantRepository;

    @Autowired
    EnterpriseRepository enterpriseRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    // Đăng kí người tìm viêc
    @PostMapping("/applicants/signup")
    public ResponseEntity<?> createApplicant(@RequestBody Applicant applicant) {
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
                .orElseThrow(() -> new RuntimeException("Không tìm tấy Role"));
        ;

        roles.add(userRole);
        /*
         * Tạo user trước
         */
        User user = applicant.getUser();
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setImage("default.png");

        User createdUser = userRepository.save(user);
        applicant.setUser(createdUser);

        return ResponseEntity.ok(applicantRepository.save(applicant));
    }

    // Đăng kí nhà tuyển dụng
    @PostMapping("/enterprises/signup")
    public ResponseEntity<?> createEnterprise(@RequestBody Enterprise enterprise) {
        Set<Role> roles = new HashSet<>();

        //Kiểm tra username đã tồn tại
        if (userRepository.existsByUsername(enterprise.getUser().getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Username đã tồn tại!"));
        }

        //Kiểm tra email đã tồn tại
        if (userRepository.existsByEmail(enterprise.getUser().getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Email đã tồn tại!"));
        }

        Role userRole = roleRepository.findByName(EnumRole.ROLE_ENTERPRISE)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Role"));

        roles.add(userRole);
        /*
         * Tạo user trước
         */
        User user = enterprise.getUser();
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setImage("default.png");

        User createdUser = userRepository.save(user);
        enterprise.setUser(createdUser);

        return ResponseEntity.ok(enterpriseRepository.save(enterprise));
    }
}