package br.com.perceptron.marketplace.exceptions;

import br.com.perceptron.marketplace.response.ResponseDTO;
import br.com.perceptron.marketplace.response.ResponseErrorDetails;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.support.MetaDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.RollbackException;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.perceptron.marketplace.response.ResponseUtils.objectWithRelationship;
import static br.com.perceptron.marketplace.response.ResponseUtils.titleValidation;
import static java.util.Objects.nonNull;

@Getter
@RestControllerAdvice
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;
    private List<ResponseErrorDetails> datas;
    private ResponseDTO<Object> responseDTO = new ResponseDTO<>();

    private ResponseEntity<Object> getResponseError(Exception ex, HttpStatus status, HttpServletRequest request, String method) {
        StandardError error = new StandardError(new Date().getTime(), status.value(), ex.getMessage(), ex.getMessage(), ex.getMessage(), nonNull(request) ? request.getContextPath() : null);
        return responseDTO.error(status, error.getMessage(), this.getClass(), method, ex);
    }

    private ResponseEntity<Object> getResponseError(String ex, HttpStatus status, WebRequest request, String method) {
        StandardError error = new StandardError(new Date().getTime(), status.value(), ex, ex, ex, nonNull(request) ? request.getContextPath() : null);
        return responseDTO.error(status, error.getMessage(), ex.getClass(), method, null, request);
    }

    @ExceptionHandler({javax.persistence.RollbackException.class, RollbackException.class})
    public ResponseEntity<Object> rollbackException(RollbackException e, WebRequest request) {
        return getResponseError("Não foi possivel completar a ação no banco de dados", HttpStatus.INTERNAL_SERVER_ERROR, request, "metaDataAccessException");
    }

    @ExceptionHandler(MException.class)
    public ResponseEntity<Object> mException(MException e, HttpServletRequest request) {
        return getResponseError(e, HttpStatus.BAD_REQUEST, request, "mException");
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Object> usernameNotFoundException(UsernameNotFoundException e, HttpServletRequest request) {
        return getResponseError(e, HttpStatus.NOT_FOUND, request, "usernameNotFoundException");
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<Object> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        return getResponseError(e, HttpStatus.NOT_FOUND, request, "objectNotFound");
    }

    @ExceptionHandler(ErrorConverterID.class)
    public ResponseEntity<Object> errorConverterID(ErrorConverterID e, HttpServletRequest request) {
        return getResponseError(e, HttpStatus.NOT_FOUND, request, "errorConverterID");
    }

    @ExceptionHandler(MConstraintViolationException.class)
    public ResponseEntity<Object> mConstraintViolationException(MConstraintViolationException e, HttpServletRequest request) {
        return getResponseError(e, HttpStatus.BAD_REQUEST, request, "mConstraintViolationException");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> mDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
        return getResponseError(objectWithRelationship(messageSource), HttpStatus.BAD_REQUEST, null, "mDataIntegrityViolationException");
    }

    @ExceptionHandler(MDataIntegrityViolationException.class)
    public ResponseEntity<Object> mDataIntegrityViolationException(MDataIntegrityViolationException e, HttpServletRequest request) {
        return getResponseError(e, HttpStatus.BAD_REQUEST, null, "mDataIntegrityViolationException");
    }

    @ExceptionHandler(BeanCreationException.class)
    public ResponseEntity<Object> beanCreationException(BeanCreationException e, HttpServletRequest request) {
        return getResponseError(e, HttpStatus.INTERNAL_SERVER_ERROR, request, "beanCreationException");
    }

    @ExceptionHandler(SQLSyntaxErrorException.class)
    public ResponseEntity<Object> sQLSyntaxErrorException(SQLSyntaxErrorException e, HttpServletRequest request) {
        return getResponseError(e, HttpStatus.INTERNAL_SERVER_ERROR, request, "sQLSyntaxErrorException");
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> nullPointerException(NullPointerException e, HttpServletRequest request) {
        return getResponseError(e, HttpStatus.INTERNAL_SERVER_ERROR, request, "nullPointerException");
    }

    @ExceptionHandler(MetaDataAccessException.class)
    public ResponseEntity<Object> metaDataAccessException(MetaDataAccessException e, HttpServletRequest request) {
        return getResponseError(e, HttpStatus.INTERNAL_SERVER_ERROR, request, "metaDataAccessException");
    }

    @ExceptionHandler(CannotGetJdbcConnectionException.class)
    public ResponseEntity<Object> cannotGetJdbcConnectionException(CannotGetJdbcConnectionException e, HttpServletRequest request) {
        return getResponseError(e, HttpStatus.INTERNAL_SERVER_ERROR, request, "cannotGetJdbcConnectionException");
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> sQLException(SQLException e, HttpServletRequest request) {
        return getResponseError(e, HttpStatus.INTERNAL_SERVER_ERROR, request, "sQLException");
    }

    @ExceptionHandler(UnsatisfiedDependencyException.class)
    public ResponseEntity<Object> unsatisfiedDependencyException(UnsatisfiedDependencyException e, HttpServletRequest request) {
        return getResponseError(e, HttpStatus.INTERNAL_SERVER_ERROR, request, "unsatisfiedDependencyException");
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getResponseError("Método " + ex.getMethod() + " não implementado ou não permitido, por favor verifique e tente novamente", status, request, "handleHttpRequestMethodNotSupported");
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getResponseError(ex.getMessage(), status, request, "handleHttpMediaTypeNotSupported");
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getResponseError(ex.getMessage(), status, request, "handleHttpMediaTypeNotAcceptable");
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getResponseError(ex.getMessage(), status, request, "handleMissingPathVariable");
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getResponseError(ex.getMessage(), status, request, "handleMissingServletRequestParameter");
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getResponseError(ex.getMessage(), status, request, "handleServletRequestBindingException");
    }

    @Override
    protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getResponseError(ex.getMessage(), status, request, "handleConversionNotSupported");
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getResponseError(ex.getMessage(), status, request, "handleTypeMismatch");
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getResponseError(ex.getMessage(), status, request, "handleHttpMessageNotReadable");
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getResponseError(ex.getMessage(), status, request, "handleHttpMessageNotWritable");
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getResponseError(ex.getMessage(), status, request, "handleMissingServletRequestPart");
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getResponseError(ex.getMessage(), status, request, "handleBindException");
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getResponseError(ex.getMessage(), status, request, "handleNoHandlerFoundException");
    }

    @Override
    protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getResponseError(ex.getMessage(), status, request, "handleAsyncRequestTimeoutException");
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return getResponseError(ex.getMessage(), status, request, "handleExceptionInternal");
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ResponseErrorDetails> errors = getErrors(ex);
        this.datas = errors;
        return responseDTO.error(status, titleValidation(messageSource), datas, ex.getClass(), "handleMethodArgumentNotValid", ex, request);

    }

    private List<ResponseErrorDetails> getErrors(MethodArgumentNotValidException ex) {

        return ex.getBindingResult()
                .getFieldErrors().stream()
                .map(e -> new ResponseErrorDetails(e.getField(), e.getDefaultMessage()))
                .collect(Collectors.toList());
    }
}
