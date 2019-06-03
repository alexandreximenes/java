package br.com.perceptron.marketplace.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class MDataIntegrityViolationException extends DataIntegrityViolationException {
    public MDataIntegrityViolationException(String msg) {
        super(msg);
    }
}
