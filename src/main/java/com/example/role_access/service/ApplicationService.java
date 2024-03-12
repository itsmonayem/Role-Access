package com.example.role_access.service;

import com.example.role_access.Status;
import com.example.role_access.entity.Application;
import com.example.role_access.entity.ApplicationHistory;
import com.example.role_access.entity.User;
import com.example.role_access.repository.ApplicationRepository;
import com.example.role_access.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ApplicationService {

   private final UserRepository userRepository;

    private final  ApplicationRepository applicationRepository;

    public void save(Application application) {
        applicationRepository.save(application);
    }


    public Optional<Application> getApplication(Long applicationId) {
        return applicationRepository.findById(applicationId);
    }

    public List<Application> getApplicationByUser(User user) {
        return this.applicationRepository.findApplicationsByUser(user);
    }

    public List<Application> getAllApplication() {
        return this.applicationRepository.findAll();
    }
}
