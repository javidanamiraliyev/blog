package com.javidan.blog.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@Entity
public class Author extends BaseEntity{
    @Column
    @NotEmpty
    private String firstName;

    @Column
    @NotEmpty
    private String lastName;

    @Column
    @NotEmpty
    private String bio;

    @OneToOne
    private User account = null;

    public Author() {
    }

    public Author(String firstName, String lastName, String bio,User account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.account = account;
    }

}
