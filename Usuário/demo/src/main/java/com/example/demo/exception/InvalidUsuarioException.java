package com.example.demo.exception;

public class InvalidUsuarioException extends RuntimeException {
    public InvalidUsuarioException(String message) {
        super(message);
    }
}
