package com.javidan.blog.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST; //400
    private final HttpStatus NOT_FOUND = HttpStatus.NOT_FOUND;
    private final HttpStatus CONFLICT = HttpStatus.CONFLICT; //409
    private final HttpStatus INTERNAL_SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR; //500

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex){
        ErrorResponse errorResponse = new ErrorResponse("Unknown error",INTERNAL_SERVER_ERROR.value(),ex.getStackTrace());
        return new ResponseEntity<>(errorResponse,INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({EmailAlreadyUsedException.class})
    public ResponseEntity<ErrorResponse> handleEmailAlreadyUsedException(EmailAlreadyUsedException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),CONFLICT.value(),ex.getStackTrace());
        return new ResponseEntity<>(errorResponse,CONFLICT);
    }

    @ExceptionHandler({URISyntaxException.class})
    public ResponseEntity<ErrorResponse> handleURISyntaxException(URISyntaxException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), BAD_REQUEST.value(), ex.getStackTrace());
        return new ResponseEntity<>(errorResponse,BAD_REQUEST);
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), NOT_FOUND.value(), ex.getStackTrace());
        return new ResponseEntity<>(errorResponse,NOT_FOUND);
    }
}
