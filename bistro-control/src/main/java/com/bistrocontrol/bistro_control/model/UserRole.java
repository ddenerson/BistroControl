package com.bistrocontrol.bistro_control.model;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
