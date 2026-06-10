package org.universidade.controlepresenca.service;

public class InvalidCredentialsException extends RuntimeException {

    public InvalidCredentialsException() {
        super("Credenciais inválidas");
    }
}
