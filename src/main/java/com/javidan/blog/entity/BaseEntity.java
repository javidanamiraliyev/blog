package com.javidan.blog.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @CreationTimestamp
    @Column
    private Timestamp created;

    @UpdateTimestamp
    @Column
    private Timestamp updated;

    public BaseEntity() {

    }
}
