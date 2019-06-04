package com.oauth2.demo.resource.response;

import com.oauth2.demo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class Response {

    @Autowired
    private MessageSource messageSource;

    public static String searchOK(){
        return getMessageSource(messageSource,"busca.ok");
    }

    public static ObjectNotFoundException objectNotFound(){
        return () -> new ObjectNotFoundException(getMessageSource(messageSource, "object.not.found"));
    }

    private static String getMessageSource(String message){
        return messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
    }
}
