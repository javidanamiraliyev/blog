package com.javidan.blog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Article extends BaseEntity {
    @Column
    @NotEmpty
    private String title;

    @Column
    @NotEmpty
    private String body;

}
