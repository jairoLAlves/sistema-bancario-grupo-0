package br.com.banco.exceptions;

public class OperacaoInvalida extends RuntimeException {
    public OperacaoInvalida(String message) {
        super(message);
    }
}
