package com.oauth2.demo.resource.exception;

import com.oauth2.demo.resource.response.I18n;
import com.oauth2.demo.service.exception.BadRequestException;
import com.oauth2.demo.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ResourceExceptionHandler {

    private final I18n i18n;

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> objectNotFoundException(ObjectNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(StandartError.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .error(ex.getMessage())
                        .message(i18n.notFound())
                        .path(request.getRequestURI())
                        .remoteUser(request.getRemoteUser())
                        .build()
                );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StandartError> badRequestException(BadRequestException ex, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(StandartError.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .error(ex.toString().substring(0,50).concat("..."))
                        .message(i18n.notFound())
                        .path(request.getRequestURI())
                        .remoteUser(request.getRemoteUser())
                        .build()
                );
    }
}