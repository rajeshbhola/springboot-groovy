package com.bholacodecamp.exception


import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException)
    ResponseEntity<?> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        Map<String, String> response = [
                "message": ex.getMessage(),
                "details": request.getDescription(false)
        ]
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(Exception)
    ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        Map<String, String> response = [
                "message": "An unexpected error occurred",
                "details": request.getDescription(false)
        ]
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
