package com.javidan.blog.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@Entity
public class Comment extends BaseEntity{
    @Column
    @NotEmpty
    private String body;

    @ManyToOne(optional = false)
    private User author;

    @ManyToOne(optional = false)
    private User updatedBy;

    @ManyToOne(optional = false)
    private Article article;

    public Comment() {
    }

}
