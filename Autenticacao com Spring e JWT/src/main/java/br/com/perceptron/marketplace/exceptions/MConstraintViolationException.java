package br.com.perceptron.marketplace.exceptions;

public class MConstraintViolationException extends RuntimeException {
    public MConstraintViolationException(String message) {
        super(message);
    }
}
