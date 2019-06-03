package br.com.perceptron.marketplace.email;

import br.com.perceptron.marketplace.response.ResponseDTO;
import br.com.perceptron.marketplace.utils.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import static br.com.perceptron.marketplace.response.ResponseUtils.EMAIL_NAO_ENVIADO;

public class EmailSupport {

    static Email email = null;
    private ResponseDTO<Email> responseDTO = new ResponseDTO<>();

    {
        email = new Email();
        email.setFrom("alexandre.ximenes@livetouch.com.br");
        email.setTo("alexandre.ximenes@livetouch.com.br");
    }

    public Email getDefaultSuccess(Class<?> clazz, String method) {
        try {

            String mClass = clazz != null ? clazz.getSimpleName() : "";
            String mMethod = method != null ? method : "";

            email.setSubject("Support Perceptron Marketplace - [SUCCESS em " + clazz.getSimpleName() + "]");
            email.setMessage(new StringBuffer().append("DATA DA OCORRÊNCIA: \n").append(DateUtils.toBR()).append("\n").append(mClass + "." + mMethod).toString());
        } catch (Exception ex) {
            responseDTO.error(HttpStatus.BAD_REQUEST, EMAIL_NAO_ENVIADO + ", " + email, this.getClass(), "getDefaultSuccess", ex);
        }
        return email;
    }

    public Email getDefaultError(HttpStatus status, Object message, Class<?> clazz, String method, Exception e) {
        try {
            String mStatus = status != null ? "\nStatus HTTP: " + status.value() + " " + status.name() : "";
            String mMessage = message != null ? "\nMensagem: " + message : "";
            String mClass = clazz != null ? "\nClasse: " + clazz.getName() + (method != null ? "." + method : "") : "";
            String mException = e != null ? "\nExceção: " + e : "";

            email.setSubject(new StringBuffer().append("Support Perceptron marketplace - [ERRO em " + clazz.getSimpleName() + "]").toString());
            email.setMessage(new StringBuffer().append("DATA DA OCORRÊNCIA: ").append(DateUtils.toBR()).append("\n").append(mStatus).append(mMessage).append(mClass).append(mException).toString());

        } catch (Exception ex) {
            responseDTO.error(HttpStatus.BAD_REQUEST, EMAIL_NAO_ENVIADO + ", " + email, this.getClass(), "getDefaultError", ex);
        }
        return email;
    }

    public Email getOrderSuccess() {
        return null;
    }

    public Email getDefaultError(HttpStatus status, Object message, Class<?> clazz, String method, Exception e, WebRequest request) {
        try {
            String mStatus = status != null ? "\nStatus HTTP: " + status.value() + " " + status.name() : "";
            String mMessage = message != null ? "\nMensagem: " + message : "";
            String mClass = clazz != null ? "\nClasse: " + clazz.getName() + (method != null ? "." + method : "") : "";
            String mException = e != null ? "\nExceção: " + e : "";
            String mRequest = request != null ? "\nRequisição HTTP: " + request : "";

            email.setSubject(new StringBuffer().append("Support Perceptron marketplace - [ERRO em " + clazz.getSimpleName() + "]").toString());
            email.setMessage(new StringBuffer().append("DATA DA OCORRÊNCIA: ").append(DateUtils.toBR()).append("\n").append(mStatus).append(mMessage).append(mClass).append(mException).toString());

        } catch (Exception ex) {
            responseDTO.error(HttpStatus.BAD_REQUEST, EMAIL_NAO_ENVIADO + ", " + email, this.getClass(), "getDefaultError", ex);
        }
        return email;
    }
}
