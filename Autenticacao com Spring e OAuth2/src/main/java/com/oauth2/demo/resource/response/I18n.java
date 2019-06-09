package com.oauth2.demo.resource.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class I18n {

    @Autowired
    private MessageSource messageSource;

    public String searchOk(){
        return getMessageSource("busca.ok");
    }

    public String notFound(){
        return getMessageSource("object.not.found");
    }

    public String notSaved(){
        return getMessageSource("not.saved");
    }

    private String getMessageSource(String message){
        return messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
    }
}
