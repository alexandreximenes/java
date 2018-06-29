package br.com.treinamento.springboot.demo.handler;

import br.com.treinamento.springboot.demo.error.ResourceNotFoundDetail;
import br.com.treinamento.springboot.demo.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException rfnException){

        ResourceNotFoundDetail rfnDetail = ResourceNotFoundDetail.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status((long) HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .detail(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();
    return new ResponseEntity<>(rfnDetail, HttpStatus.NOT_FOUND);

    }

}
