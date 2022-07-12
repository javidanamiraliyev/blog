package com.javidan.blog.controller.rest;

import com.javidan.blog.dto.ArticleDTO;
import com.javidan.blog.entity.Article;
import com.javidan.blog.exceptions.ArticleNotFoundException;
import com.javidan.blog.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
@RequestMapping("/api/articles")
public class ArticleRestController {
    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public Article getArticleById(@NotNull @PathVariable Long id) throws ArticleNotFoundException{
        Optional<Article> article = articleService.getArticleById(id);
        if(article.isEmpty()) throw new ArticleNotFoundException();
        else return article.get();
    }

    @GetMapping
    public Page<Article> getAllArticles(@RequestParam int page,
                                        @RequestParam int size,
                                        @RequestParam(required = false) String sortBy,
                                        @RequestParam(required = false) String sortDirection){
        PageRequest pageRequest = PageRequest.of(page, size);
        if(sortBy != null){
            pageRequest = PageRequest.of(page, size, Sort.by(sortBy));
        }
        if(sortDirection != null){
            pageRequest = PageRequest.of(page,size,Sort.by(Sort.Direction.valueOf(sortDirection),sortBy));
        }
        return articleService.getAllArticles(pageRequest);
    }

    @PostMapping
    public Article createArticle(@RequestBody @Validated ArticleDTO dto){
        return articleService.createArticle(dto);
    }
}
