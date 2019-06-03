package br.com.perceptron.marketplace.security;

import br.com.perceptron.marketplace.utils.DateUtils;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static br.com.perceptron.marketplace.response.ResponseUtils.notPermission;

@Component
public class UnauthorizedHandler implements AuthenticationEntryPoint {

    @Autowired
    private MessageSource messageSource;

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        responseUnauthorizedHandler(
                HttpStatus.FORBIDDEN,
                MediaType.APPLICATION_JSON_UTF8_VALUE,
                response,
                getResponseMessage(notPermission(messageSource))
        );
    }

    public static HttpServletResponse responseUnauthorizedHandler(HttpStatus status, String contentType, HttpServletResponse response, String message) throws IOException {
        response.setStatus(status.value());
        response.setContentType(contentType);
        response.getWriter().write(message);
        return response;
    }

    public static String getResponseMessage(String message) {
        JsonObject json = new JsonObject();
        json.addProperty("message", message);
        json.addProperty("dateTime", DateUtils.getDefaultBR());
        return json.toString();
    }

}
