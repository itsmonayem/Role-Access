package com.example.role_access.entity;

import com.example.role_access.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
@Entity
@NoArgsConstructor

@Getter
@Setter
public class ApplicationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Status action;
    @OneToOne
    private User Action_taken_by;
    private LocalTime time;

    public ApplicationHistory(Status action, User action_taken_by, LocalTime time) {
        this.action = action;
        Action_taken_by = action_taken_by;
        this.time = time;
    }
}
