package com.example.role_access.repository;

import com.example.role_access.entity.ApplicationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationHistoryRepo extends JpaRepository<ApplicationHistory, Long> {
}
