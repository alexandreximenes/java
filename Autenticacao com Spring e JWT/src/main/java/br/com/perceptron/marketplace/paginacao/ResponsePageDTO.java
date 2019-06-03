package br.com.perceptron.marketplace.paginacao;

import br.com.perceptron.marketplace.log.Logs;
import br.com.perceptron.marketplace.utils.DateUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.io.Serializable;
import java.util.List;

public class ResponsePageDTO<T> implements Serializable {

    public String message;
    public String dateTime;
    public List<T> datas;
    public PageInfo pagination;

    public ResponsePageDTO() {
    }

    private ResponsePageDTO(String message) {
        this.dateTime = DateUtils.getDefaultBR();
        this.message = message;
    }

    public ResponsePageDTO(String message, Page<T> page) {
        this.dateTime = DateUtils.getDefaultBR();
        this.message = message;
        pagination = new PageInfo(page.getNumber(), page.getTotalPages(), page.getTotalElements(), page.isFirst(), page.isLast(), page.getSort().isSorted(), page.getNumberOfElements(), page.getSize(), page.isEmpty());
        datas = page.getContent();
    }

    public ResponseEntity<ResponsePageDTO> success(HttpStatus status, String message, Page<T> page, Class<?> mClass) {
        registrarLogDeSucesso(status, message, page, mClass);
        return ResponseEntity.ok(new ResponsePageDTO(message, page));
    }

    public ResponseEntity<ResponsePageDTO> error(HttpStatus status, String error, Class<?> mClass, String method, Exception e) {
        registrarLogDeErro(status, error, mClass, method, e, null, null);
        return ResponseEntity
                .status(obtemStatus(status))
                .body(new ResponsePageDTO(error));
    }

    private HttpStatus obtemStatus(HttpStatus status) {
        return status != null ? status : HttpStatus.BAD_REQUEST;
    }

    public ResponseEntity<Object> error(HttpStatus status, String error, Class<?> mClass, String method, Exception e, HttpHeaders headers, WebRequest request) {
        registrarLogDeErro(status, error, mClass, method, e, headers, request);
        return ResponseEntity
                .status(obtemStatus(status))
                .body(new ResponsePageDTO(error));
    }

    private void registrarLogDeErro(HttpStatus status, String error, Class<?> mClass, String method, Exception e, HttpHeaders headers, WebRequest request) {
        //FIXME criar table de parametros para salvar esse tipo de dado
        if (true) new Logs(mClass).error(status, error, mClass, method, e, headers, request);
    }

    private void registrarLogDeSucesso(HttpStatus status, String message, Object object, Class<?> mClass) {
        //FIXME criar table de parametros para salvar esse tipo de dado
        if (true) new Logs(mClass).info(status, message, object, mClass);
    }
}
