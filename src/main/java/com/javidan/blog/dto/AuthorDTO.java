package com.javidan.blog.dto;

import com.javidan.blog.entity.User;
import lombok.Data;

@Data
public class AuthorDTO {
    private String firstName;
    private String lastName;
    private String bio;
    private User account;

    public AuthorDTO() {
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public User getAccount() {
        return account;
    }

    public void setAccount(User account) {
        this.account = account;
    }
}
