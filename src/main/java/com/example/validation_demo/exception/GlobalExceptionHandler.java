package com.example.validation_demo.exception;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.time.Instant;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidation(MethodArgumentNotValidException ex) {
        List<Map<String,String>> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fe ->
            errors.add(Map.of("field", fe.getField(), "message", Objects.requireNonNull(fe.getDefaultMessage())))
        );
        ex.getBindingResult().getGlobalErrors().forEach(ge ->
            errors.add(Map.of("object", ge.getObjectName(), "message", Objects.requireNonNull(ge.getDefaultMessage())))
        );

        Map<String,Object> body = Map.of(
            "timestamp", Instant.now().toString(),
            "status", HttpStatus.BAD_REQUEST.value(),
            "errors", errors
        );
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
        List<Map<String,String>> errors = new ArrayList<>();
        ex.getConstraintViolations().forEach(cv ->
            errors.add(Map.of("path", cv.getPropertyPath().toString(), "message", cv.getMessage()))
        );
        Map<String,Object> body = Map.of("timestamp", Instant.now().toString(), "status", 400, "errors", errors);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
