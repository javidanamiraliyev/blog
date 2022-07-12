package com.javidan.blog.repository;

import com.javidan.blog.entity.Author;
import com.javidan.blog.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends PagingAndSortingRepository<Author,Long> {
    Optional<Author> findAuthorByAccount(User account);
}
