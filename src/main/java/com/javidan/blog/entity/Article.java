package com.javidan.blog.entity;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}
