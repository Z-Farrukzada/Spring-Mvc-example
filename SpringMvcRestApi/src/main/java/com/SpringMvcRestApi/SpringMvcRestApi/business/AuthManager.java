package com.SpringMvcRestApi.SpringMvcRestApi.business;

import com.SpringMvcRestApi.SpringMvcRestApi.jwt.jwtUtil;
import com.SpringMvcRestApi.SpringMvcRestApi.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthManager {

    private final AuthenticationManager authenticationManager;
    private final jwtUtil jwtUtil;

    public ResponseEntity<String> login(User user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        return ResponseEntity.ok(jwtUtil.generateToken(user.getUsername()));
    }
}
