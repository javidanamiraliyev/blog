package com.javidan.blog.repository;

import com.javidan.blog.domain.Role;
import com.javidan.blog.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.awt.print.Pageable;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
    Optional<User> findUserByEmail(String email);
}
