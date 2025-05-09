package com.example.demo.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ToDoExceptions.class})
    protected ResponseEntity<Object> handlerConflict(ToDoExceptions ex, WebRequest request){
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex,
                                        bodyOfResponse,
                                        new HttpHeaders(),
                                        ex.getHttpStatus(),
                                        request);
    }

}

/*import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ToDoExceptions.class)
    public ResponseEntity<String> HandlerConflict(ToDoExceptions ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}*/