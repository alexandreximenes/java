package br.com.perceptron.marketplace.domains;

import br.com.perceptron.marketplace.response.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface IService<T> {
    ResponseEntity<Object> saveOrUpdate(T t);

    ResponseEntity<Object> deleteById(Long id);

    ResponseEntity<Object> findById(Long id);

    ResponseEntity<Object> findAll(Integer pagina, Integer quantidade, String ordenarPor, String direcaoOrdenacao, String parametro);

    default ResponseEntity<Object> $200(String message, Object object, Class<?> clazz) {
        return new ResponseDTO().success(HttpStatus.OK, message, object, clazz);
    }

    default ResponseEntity<Object> $400(String message, Object object, Class<?> clazz) {
        return new ResponseDTO().success(HttpStatus.NOT_FOUND, message, object, clazz);
    }


}
