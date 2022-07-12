package com.javidan.blog.repository;

import com.javidan.blog.entity.Article;
import com.javidan.blog.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article,Long> {
    Page<Article> findArticlesByCreated(Timestamp created, Pageable pageable);
    Page<Article> findArticlesByAuthor(@NotNull Author author, Pageable pageable);
}
