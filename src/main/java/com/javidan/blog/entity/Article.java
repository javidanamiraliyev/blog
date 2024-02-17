package com.javidan.blog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Article extends BaseEntity {
    @Column
    @NotEmpty
    private String title;

    @Column
    @NotEmpty
    private String body;

    @ManyToOne
    @NotNull
    private Author author;

    @Column
    private String thumbnailUrl;

    @ElementCollection
    private Set<String> tags = new HashSet<>();

    public Article(String title, String body, Author author, String thumbnailUrl, Set<String> tags) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.thumbnailUrl = thumbnailUrl;
        this.tags = tags;
    }

    public Article() {

    }

}
