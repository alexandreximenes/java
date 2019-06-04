package com.oauth2.demo.service.exception;

import java.io.Serializable;

public class ObjectNotFoundException extends RuntimeException implements Serializable {

    public ObjectNotFoundException(String message) {
        super(message);
    }

}
