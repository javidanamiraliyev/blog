package com.javidan.blog.exceptions;

public class ArticleNotFoundException extends RuntimeException{
    public ArticleNotFoundException() {
        super("Article is not found");
    }
}
