package com.javidan.blog.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("User is not found");
    }
}
