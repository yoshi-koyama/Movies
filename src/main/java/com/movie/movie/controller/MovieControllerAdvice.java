package com.movie.movie.controller;

import com.movie.movie.exception.InvalidYearRangeException;
import com.movie.movie.exception.MovieNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
import java.util.Map;

@ControllerAdvice
public class MovieControllerAdvice {

    //映画がみつからない場合の例外処理
    @ExceptionHandler(value = MovieNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleMovieNotFoundException(
            MovieNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    //年数が不正な場合の例外処理
    @ExceptionHandler(value = InvalidYearRangeException.class)
    public ResponseEntity<Map<String, String>> handleInvalidYearRangeException(
            InvalidYearRangeException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.BAD_REQUEST.value()),
                "error", HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
