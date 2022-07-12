package com.javidan.blog.dto;

import com.javidan.blog.entity.Author;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class ArticleDTO {
    @NotEmpty
    private String title;
    @NotEmpty
    private String body;
    @NotNull
    private Author author;
    private String thumbnailUrl;
    private Set<String> tags;

    public ArticleDTO(String title, String body, Author author, String thumbnailUrl, Set<String> tags) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.thumbnailUrl = thumbnailUrl;
        this.tags = tags;
    }

    public ArticleDTO() {
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
