package com.javidan.blog.service;

import com.javidan.blog.dto.ArticleDTO;
import com.javidan.blog.dto.DTOMapper;
import com.javidan.blog.entity.Article;
import com.javidan.blog.entity.Author;
import com.javidan.blog.repository.ArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Optional<Article> getArticleById(Long id){
        return articleRepository.findById(id);
    }

    public Page<Article> getAllArticles(Pageable pageable){
        return articleRepository.findAll(pageable);
    }

    public Page<Article> getArticlesByAuthor(Author author, Pageable pageable){
        return articleRepository.findArticlesByAuthor(author, pageable);
    }

    public Article createArticle(ArticleDTO dto){
        return articleRepository.save(DTOMapper.mapToEntity(dto));
    }
}
