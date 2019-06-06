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

    public String searchOK(){
        return getMessageSource("busca.ok");
    }

    public String objectNotFound(){
        return getMessageSource("object.not.found");
    }

    private String getMessageSource(String message){
        return messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
    }
}
