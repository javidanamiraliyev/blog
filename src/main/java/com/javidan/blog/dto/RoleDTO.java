package com.javidan.blog.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleDTO {
    private String name;

    public RoleDTO(String name) {
        this.name = name;
    }

}
