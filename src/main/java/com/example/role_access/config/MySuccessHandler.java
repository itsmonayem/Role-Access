package com.example.role_access.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MySuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (authentication instanceof UsernamePasswordAuthenticationToken upAt) {
            System.out.println(upAt);
            CustomUserDetails customUserDetails = (CustomUserDetails) upAt.getPrincipal();


            if("ROLE_USER_A".equals(customUserDetails.getUser().getRole())){
                response.sendRedirect("/user-A/");
            } else if("ROLE_USER_B".equals(customUserDetails.getUser().getRole())){
                response.sendRedirect("/user-B/");
            } else if("ROLE_USER_C".equals(customUserDetails.getUser().getRole())){
                response.sendRedirect("/user-C/");
            } else if("ROLE_USER_D".equals(customUserDetails.getUser().getRole())){
                response.sendRedirect("/user-D/");
            } else if("ROLE_ADMIN".equals(customUserDetails.getUser().getRole())){
                response.sendRedirect("/admin/");
            }
        }

    }
}
