package br.com.perceptron.marketplace.email;

import lombok.Data;

@Data
public class Email {
    private String from;
    private String to;
    private String subject;
    private String message;
    private boolean isAtivo;
}
