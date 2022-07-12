package com.javidan.blog.exceptions;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
    private final int status;
    private final String message;
    private final LocalDateTime timestamp;

    public ErrorResponse(int status, String message){
        super();
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
