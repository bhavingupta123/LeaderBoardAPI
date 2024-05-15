package com.example.leaderboardgame.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Global exception handler for handling exceptions across all controllers in the application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles general exceptions that occur within the application.
     * Returns a generic error message with HTTP status 500 (Internal Server Error).
     * @param ex The exception that occurred.
     * @return ResponseEntity containing the error message and status code.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred. Please try again later.");
    }

    /**
     * Handles MethodArgumentTypeMismatchException, which occurs when method arguments are not of the expected type.
     * Used to handle situations where the game ID provided in the request is not a valid format.
     * Returns a message indicating the invalid game ID format with HTTP status 400 (Bad Request).
     * @param ex The exception that occurred.
     * @return ResponseEntity containing the error message and status code.
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>("Invalid game ID format", HttpStatus.BAD_REQUEST);
    }
}
