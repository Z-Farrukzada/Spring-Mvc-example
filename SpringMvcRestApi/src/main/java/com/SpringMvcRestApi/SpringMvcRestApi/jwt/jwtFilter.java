package com.SpringMvcRestApi.SpringMvcRestApi.jwt;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("ALL")
@Component
public class jwtFilter extends OncePerRequestFilter {

    @Autowired
    jwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = httpServletRequest.getHeader("Authorization");

        String username = null;
        String token = null;

        if (null != authHeader && authHeader.contains("Bearer")) {
            token = authHeader.substring(7);
            try {
                username = jwtUtil.getUsernameToken(token);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwtUtil.tokenValidate(token)) {
                val passToken = new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
                passToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(passToken);
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }


}
