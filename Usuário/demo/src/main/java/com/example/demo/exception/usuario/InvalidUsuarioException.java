package com.example.demo.exception.usuario;

public class InvalidUsuarioException extends RuntimeException {
    public InvalidUsuarioException(String message) {
        super(message);
    }
}
