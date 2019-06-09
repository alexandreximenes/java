package com.oauth2.demo.service.exception;

import java.io.Serializable;

public class BadRequestException extends RuntimeException implements Serializable {

    public BadRequestException(String message) {
        super(message);
    }

}
