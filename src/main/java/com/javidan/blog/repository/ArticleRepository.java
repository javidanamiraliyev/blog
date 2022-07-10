package com.javidan.blog.repository;

import com.javidan.blog.domain.Article;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article,Long> {
}
