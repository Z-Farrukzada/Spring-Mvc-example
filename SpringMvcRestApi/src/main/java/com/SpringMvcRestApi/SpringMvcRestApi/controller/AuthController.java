package com.SpringMvcRestApi.SpringMvcRestApi.controller;

import com.SpringMvcRestApi.SpringMvcRestApi.service.AuthService;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO){
        return authService.login(userDTO);
    }

}
