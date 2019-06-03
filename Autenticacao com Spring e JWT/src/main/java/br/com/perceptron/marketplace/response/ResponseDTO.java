package br.com.perceptron.marketplace.response;

import br.com.perceptron.marketplace.email.EmailNotification;
import br.com.perceptron.marketplace.log.Logs;
import br.com.perceptron.marketplace.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> implements Serializable {

    private int status;
    private String message;
    private String dateTime;
    private Object data;
    private List<Object> datas;

    private String object;
    private List<ResponseErrorDetails> errors;

    public ResponseDTO(int status, String message, Object data) {
        this(status, message);
        this.data = data;
    }

    public ResponseDTO(int status, String message) {
        this.status = status;
        this.dateTime = DateUtils.toBR();
        this.message = message;
    }


    public ResponseDTO(int status, String message, List<Object> datas) {
        this(status, message);
        this.datas = datas;
    }

    public ResponseEntity<Object> error(HttpStatus status, Object message, Class<?> clazz, String method, Exception e) {
        if (status.is5xxServerError()) {
            new EmailNotification().sendError(status, message, clazz, method, e);
        }
        new Logs(clazz).error(status, message, clazz, method, e, null, null);
        return ResponseEntity.status(status).body(new ResponseDTO(status.value(), message.toString()));
    }

    public ResponseEntity<Object> error(HttpStatus status, Object message, List<ResponseErrorDetails> datas, Class<?> clazz, String method, Exception e, WebRequest request) {
        ResponseDTO response = new ResponseDTO(status.value(), this.message, datas);
        sendEmailError5xx(status, message, clazz, method, e, request);

        new Logs(clazz).error(status, message, clazz, method, e, null, request);
        return ResponseEntity.status(status).body(response);
    }

    public ResponseEntity<Object> error(HttpStatus status, Object message, Class<?> clazz, String method, Exception e, WebRequest request) {
        sendEmailError5xx(status, message, clazz, method, e, request);
        new Logs(clazz).error(status, message, clazz, method, e, null, request);
        return ResponseEntity.status(status).body(new ResponseDTO(status.value(), message.toString()));
    }

    public ResponseEntity<Object> success(HttpStatus status, String message, List<Object> datas, Class<?> clazz) {
        ResponseDTO response = new ResponseDTO(status.value(), this.message, datas);
        new Logs(clazz).info(status, message, data, clazz);
        return ResponseEntity.status(status).body(response);
    }

    public ResponseEntity<Object> success(HttpStatus status, String message, Object data, Class<?> clazz) {
        new Logs(clazz).info(status, message, data, clazz);
        ResponseDTO response = new ResponseDTO(status.value(), message, data);
        return ResponseEntity.status(status).body(response);
    }

    public ResponseEntity<Object> success(HttpStatus status, String message, Class<?> clazz) {
        new Logs(clazz).info(status, message, data, clazz);
        ResponseDTO response = new ResponseDTO(status.value(), message);
        return ResponseEntity.status(status).body(response);
    }

    public void sendEmailError5xx(HttpStatus status, Object message, Class<?> clazz, String method, Exception e, WebRequest request) {
        if (status.is5xxServerError()) {
            new EmailNotification().sendError(status, message, clazz, method, e, request);
        }
    }
}
