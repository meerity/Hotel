package com.example.hotel.controller;

import com.example.hotel.JwtUtils;
import com.example.hotel.data.JwtResponseDTO;
import com.example.hotel.data.UserDataRequestDTO;
import com.example.hotel.entity.Role;
import com.example.hotel.entity.User;
import com.example.hotel.repo.RoleRepository;
import com.example.hotel.repo.UserRepository;
import com.example.hotel.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    UserRepository userRepo;
    @Autowired
    RoleRepository roleRepo;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDataRequestDTO req) {
        if (userRepo.existsByUsername(req.getUsername()))
            return ResponseEntity.badRequest().body("Username taken");
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(encoder.encode(req.getPassword()));
        Role userRole = roleRepo.findByName(Role.ERole.ROLE_USER)
                .orElseThrow();
        user.setRoles(Set.of(userRole));
        userRepo.save(user);
        return ResponseEntity.ok("Registered");
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> login(@RequestBody UserDataRequestDTO req) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        String token = jwtUtils.generateJwtToken(auth);
        UserDetailsImpl ud = (UserDetailsImpl) auth.getPrincipal();
        List<String> roles = ud.getAuthorities()
                .stream()
                .map(Objects::toString)
                .toList();
        return ResponseEntity.ok(new JwtResponseDTO(token, ud.getUsername(), roles));
    }
}

