package com.example.role_access.repository;

import com.example.role_access.entity.Application;
import com.example.role_access.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    @Query("select ap from Application  ap where ap.user= :user")
    List<Application> findApplicationsByUser(@Param("user") User user);

    @Query("select ap from Application ap where ap.id= :id")
    Application getApplicationById(@Param("id") Long id);
}
