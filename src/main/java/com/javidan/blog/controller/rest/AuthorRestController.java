package com.javidan.blog.controller.rest;

import com.javidan.blog.dto.AuthorDTO;
import com.javidan.blog.entity.Author;
import com.javidan.blog.service.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorRestController {
    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public Page<Author> getAllAuthors(@RequestParam int page, @RequestParam int size) {
        return authorService.getAllAuthors(PageRequest.of(page, size));
    }
}
