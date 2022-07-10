package com.javidan.blog.exceptions;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
    private final int status;
    private final String message;
    private final StackTraceElement[] stackTrace;
    private final LocalDateTime timestamp;

    public ErrorResponse(String message, int status, StackTraceElement[] stackTrace){
        super();
        this.message = message;
        this.status = status;
        this.stackTrace = stackTrace;
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

    public StackTraceElement[] getStackTrace() {
        return stackTrace;
    }
}
