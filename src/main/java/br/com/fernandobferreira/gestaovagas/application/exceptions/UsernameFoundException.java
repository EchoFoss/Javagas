package br.com.fernandobferreira.gestaovagas.application.exceptions;

public class UsernameFoundException extends RuntimeException {

    public UsernameFoundException() {
        super("Usuário já existe");
    }
}
