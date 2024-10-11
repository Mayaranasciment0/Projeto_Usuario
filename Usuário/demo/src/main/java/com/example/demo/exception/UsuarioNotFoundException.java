package com.example.demo.exception;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String message) {
        super(message);
    }

    public UsuarioNotFoundException() {
        super("Usuário não foi encontrado.");
    }
}
