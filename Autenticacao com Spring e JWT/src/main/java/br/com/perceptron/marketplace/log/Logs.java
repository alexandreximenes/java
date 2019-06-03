package br.com.perceptron.marketplace.log;

import br.com.perceptron.marketplace.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.WebRequest;

public class Logs {

    @Value("${printConsole}")
    private boolean printConsole;

    private Class<?> clazz = Logs.class;

    public Logs(Class<?> clazz) {
        this.clazz = clazz;
    }

    private Logger logger = LoggerFactory.getLogger(clazz.getClass());

    public void info(Object msg) {
        String info = getLogFormated(msg);
        logger.info(info);
    }

    public void info(HttpStatus status, String message, Object data, Class<?> clazz) {
        String erro = getLogFormated(status, message, data, clazz);
        logger.info(erro);
    }


    public void error(HttpStatus httpStatus, Object message, Class<?> clazz, String method, Exception e, HttpHeaders headers, WebRequest request) {
        String erro = getLogFormated(httpStatus, message, clazz, method, e, headers, request);
        logger.error(erro);
    }

    public void error(HttpStatus httpStatus, Object message, Class<?> clazz, String method, Exception e, WebRequest request) {
        String erro = getLogFormated(httpStatus, message, clazz, method, e, null, request);
        logger.error(erro);
    }

    public void error(Object message) {
        String erro = getLogFormated(message);
        logger.error(erro);
    }


    private String getLogFormated(Object message) {
        String error = null;
        if (StringUtils.hasText(message.toString())) {
            error = new StringBuffer()
                    .append("\n=================================================================================================\n")
                    .append("Date log: " + DateUtils.toBR())
                    .append("\n")
                    .append(message)
                    .toString();
            if (printConsole) {
                System.out.println(error);
            }
        }
        return error;
    }

    private String getLogFormated(HttpStatus status, Object message, Class<?> clazz, String method, Exception e, HttpHeaders headers, WebRequest request) {
        String mError = null;
        String mStatus = status != null ? "\nStatus HTTP: " + status.value() + " " + status.name() : "";
        String mMessage = message != null ? "\nMensagem: " + message : "";
        String mClass = clazz != null ? "\nClasse: " + clazz.getName() + (method != null ? "." + method : "") : "";
        String mException = e != null ? "\nExceção:" + e : "";
        String mHeaders = headers != null ? "\nHeaders: " + headers.values().toString() : "";
        String mRequest = request != null ? "\nRequisição HTTP: " + request : "";

        mError = new StringBuffer()
                .append("\n=================================================================================================\n")
                .append("Date log:" + DateUtils.toBR())
                .append(mStatus)
                .append(mMessage)
                .append(mClass)
                .append(mException)
                .append(mHeaders)
                .append(mRequest)
                .toString();

        if (printConsole) {
            System.out.println(mError);
        }
        return mError;
    }

    private String getLogFormated(HttpStatus status, String message, Object data, Class<?> clazz) {

        String mError = null;
        String mStatus = status != null ? "\nHttpStatus:" + status.value() + " " + status.name() : "";
        String mMessage = message != null ? "\nMessage:" + message : "";
        String mClass = clazz != null ? "\nClass:" + clazz.getName() : "";
        String mData = data != null ? "\nData:" + data : "";

        mError = new StringBuffer()
                .append("\n=================================================================================================\n")
                .append("Date log:" + DateUtils.toBR())
                .append(mStatus)
                .append(mMessage)
                .append(mClass)
                .append(mData)
                .toString();

        if (printConsole) {
            System.out.println(mError);
        }
        return mError;
    }
}
