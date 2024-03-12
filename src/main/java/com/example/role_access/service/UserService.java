package com.example.role_access.service;

import com.example.role_access.config.CustomUserDetails;
import com.example.role_access.entity.User;
import com.example.role_access.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User getLoggedInUser() {
        CustomUserDetails principal =(CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.getUserByUserName(principal.getUser().getEmail());
    }
}
