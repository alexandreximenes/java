package br.com.perceptron.marketplace.exceptions;

public class FieldEmptyException extends RuntimeException {
    public FieldEmptyException(String message) {
        super(message);
    }
}
