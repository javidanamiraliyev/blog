package com.javidan.blog.repository;

import com.javidan.blog.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    Optional<User> findUserByEmail(String email);
}
