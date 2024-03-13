package com.example.role_access.service;

import com.example.role_access.Status;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AccessService {
    public boolean hasPermissionsB(Status status) {
        return status == Status.INITIATED || status == Status.REJECTED_BY_USER_C;
    }
    public boolean hasPermissionsC(Status status) {
        return status == Status.APPROVED_BY_USER_B || status == Status.REJECTED_BY_USER_D;
    }
    public boolean hasPermissionsD(Status status) {
        return status == Status.APPROVED_BY_USER_C;
    }

    public boolean hasUserAccess(String role, String loggedInUserRole) {
        return Objects.equals(role, loggedInUserRole);
    }
}
