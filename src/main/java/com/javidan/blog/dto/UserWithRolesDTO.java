package com.javidan.blog.dto;

import com.javidan.blog.entity.Role;

import java.util.Set;

public class UserWithRolesDTO {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Set<Role> roles;

    public UserWithRolesDTO(String firstName, String lastName, String password, String email, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public UserWithRolesDTO(UserDTO dto, Set<Role> roles) {
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.password = dto.getPassword();
        this.email = dto.getEmail();
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
