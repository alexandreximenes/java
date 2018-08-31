package br.com.alexandre.app.Handler;

import br.com.alexandre.app.CustomMessage.ResourceNotFoundDetais;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;

import java.util.Calendar;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException rnfException){
        ResourceNotFoundDetais detais = ResourceNotFoundDetais.Builder
                .newBuilder()
                .timestamp(Calendar.getInstance())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .detail(rnfException.getMessage())
                .developerMessage(rnfException.getClass().getName())
                .build();

        return new ResponseEntity<>(detais, HttpStatus.NOT_FOUND);
    }
}

