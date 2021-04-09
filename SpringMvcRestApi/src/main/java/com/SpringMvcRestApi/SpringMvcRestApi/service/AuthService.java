package com.SpringMvcRestApi.SpringMvcRestApi.service;


import com.SpringMvcRestApi.SpringMvcRestApi.business.AuthManager;
import com.SpringMvcRestApi.SpringMvcRestApi.model.User;
import com.SpringMvcRestApi.SpringMvcRestApi.service.model.UserDTO;
import com.remondis.remap.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthManager authManager;
    private final Mapper<UserDTO,User> userDTOUserMapper;


    public ResponseEntity<String> login(UserDTO userDTO) {
       return authManager.login(userDTOUserMapper.map(userDTO));
    }
}
