package com.example.demo.exception.usuario;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String message) {
        super(message);
    }

    public UsuarioNotFoundException() {
        super("Usuário não foi encontrado.");
    }
}
