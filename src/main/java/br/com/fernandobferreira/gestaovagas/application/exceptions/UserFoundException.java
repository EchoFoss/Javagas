package br.com.fernandobferreira.gestaovagas.application.exceptions;

public class UserFoundException extends RuntimeException {

    public UserFoundException() {
        super("Usuário já existe");
    }
}
