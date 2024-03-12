package com.example.role_access;

import com.example.role_access.config.CustomUserDetails;
import com.example.role_access.entity.Application;
import com.example.role_access.entity.ApplicationHistory;
import com.example.role_access.entity.User;
import com.example.role_access.repository.ApplicationHistoryRepo;
import com.example.role_access.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalTime;


@Component
public class Utility {
    private final ApplicationHistoryRepo historyRepo;

    @Autowired
    private static  UserRepository userRepository;

    public Utility(ApplicationHistoryRepo historyRepo, UserRepository userRepository) {
        this.historyRepo = historyRepo;
        this.userRepository = userRepository;
    }

    public void SaveHistory(Status status, Principal principal) {
        User user = this.userRepository.getUserByUserName(principal.getName());

        ApplicationHistory history = new ApplicationHistory();
        history.setAction(status);
        history.setAction_taken_by(user);
        history.setTime(LocalTime.now());
        this.historyRepo.save(history);
    }




    public static User getLoggedInUser() {
        CustomUserDetails principal =(CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.getUserByUserName(principal.getUser().getEmail());

    }
}
