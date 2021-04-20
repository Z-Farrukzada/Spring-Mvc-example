package com.SpringMvcRestApi.SpringMvcRestApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  {

    private String username;
    private String password;

}
