package com.javidan.blog.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@Entity
public class Role extends BaseEntity {
    @Column
    @NotEmpty
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

}
