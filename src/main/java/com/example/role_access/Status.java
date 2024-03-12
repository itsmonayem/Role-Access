package com.example.role_access;

import java.util.function.Supplier;

public enum Status {
    INITIATED,
    REJECTED,
    APPROVED_BY_USER_B,
    REJECTED_BY_USER_B,
    APPROVED_BY_USER_C,
    REJECTED_BY_USER_C,
    REJECTED_BY_USER_D,
    COMPLETED;


//    private int id;
//    private String label;
//
//    Status(int id, String label) {
//        this.id = id;
//        this.label = label;
//    }
//
//    Status() {
//    }
//
//    Supplier<String>  getlabel = () -> this.label;
//    Supplier<Integer>  getId = () -> this.id;

}
