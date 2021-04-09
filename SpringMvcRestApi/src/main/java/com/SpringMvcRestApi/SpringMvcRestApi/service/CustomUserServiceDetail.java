package com.SpringMvcRestApi.SpringMvcRestApi.service;

import com.SpringMvcRestApi.SpringMvcRestApi.config.ConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomUserServiceDetail implements UserDetailsService {

    @Autowired
    ConfigProperties configProperties;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    private final Map<String, String> users = new HashMap<>();

    @PostConstruct
    public void init() {
        String username  = configProperties.getUsername();
        String password =configProperties.getPassword();
        users.put(username, passwordEncoder.encode(password));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (users.containsKey(username)) {
            return new User(username, users.get(username),new ArrayList<>());
        }
        throw new UsernameNotFoundException(username);
    }
}
