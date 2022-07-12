package com.javidan.blog.dto;

import com.javidan.blog.entity.Article;
import com.javidan.blog.entity.Author;
import com.javidan.blog.entity.Role;

public class DTOMapper {

    public static Article mapToEntity(ArticleDTO dto){
        Article article = new Article();
        article.setTitle(dto.getTitle());
        article.setBody(dto.getBody());
        article.setAuthor(dto.getAuthor());
        article.setTags(dto.getTags());
        article.setThumbnailUrl(dto.getThumbnailUrl());
        return article;
    }

    public static Role mapToEntity(RoleDTO dto){
        Role role = new Role();
        role.setName(dto.getName());
        return role;
    }

    public static Author mapToEntity(AuthorDTO dto){
        Author author = new Author();
        author.setFirstName(dto.getFirstName());
        author.setLastName(dto.getLastName());
        author.setBio(dto.getBio());
        author.setAccount(dto.getAccount());
        return author;
    }

    public static ArticleDTO mapToDTO(Article article){
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setTitle(article.getTitle());
        articleDTO.setBody(article.getBody());
        articleDTO.setAuthor(article.getAuthor());
        articleDTO.setTags(article.getTags());
        return articleDTO;
    }

    public static AuthorDTO mapToDTO(Author author){
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setFirstName(author.getFirstName());
        authorDTO.setLastName(author.getLastName());
        authorDTO.setBio(author.getBio());
        authorDTO.setAccount(author.getAccount());
        return authorDTO;
    }
}
