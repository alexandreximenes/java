package br.com.perceptron.marketplace.email;

import br.com.perceptron.marketplace.log.Logs;
import com.sun.mail.util.MailConnectException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.net.UnknownHostException;

import static br.com.perceptron.marketplace.response.ResponseUtils.EMAIL_NAO_ENVIADO;

@Service
public class EmailNotification {

    public JavaMailSender mailSender = new JavaMailSenderImpl();

    //    @Value("${sendEmail}")
    private boolean sendEmail = false;

    Logs logs = new Logs(this.getClass());


    @Async
    public void sendSimpleMailMessage(Email email) {
        if (sendEmail) {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            try {
                simpleMailMessage.setTo(email.getTo());
                simpleMailMessage.setFrom(email.getFrom());
                simpleMailMessage.setSubject(email.getSubject());
                simpleMailMessage.setText(email.getMessage());
                mailSender.send(simpleMailMessage);
            } catch (MailException e) {
                logs.error(HttpStatus.BAD_REQUEST, EMAIL_NAO_ENVIADO, EmailNotification.class, "sendSimpleMailMessage", e, null, null);
            }
        } else {
            logs.error(HttpStatus.BAD_REQUEST, EMAIL_NAO_ENVIADO, EmailNotification.class, "sendSimpleMailMessage", null, null, null);
        }
    }

    @Async
    public void sendMimeMailMessage(Email email) throws MailConnectException, UnknownHostException {
        if (sendEmail) {
            MimeMessage message = mailSender.createMimeMessage();
            try {
                MimeMessageHelper helper = new MimeMessageHelper(message, true);
                helper.setTo(email.getTo());
                helper.setText(getTemplateEmail(), true);
                helper.setSubject("Mail From Spring Boot");
                ClassPathResource file = new ClassPathResource("document.PNG");
                helper.addAttachment("document.PNG", file);
            } catch (MessagingException e) {
                logs.error(HttpStatus.BAD_REQUEST, EMAIL_NAO_ENVIADO, EmailNotification.class, "sendSimpleMailMessage", e, null, null);
            }
            mailSender.send(message);
        } else {
            logs.error(HttpStatus.BAD_REQUEST, EMAIL_NAO_ENVIADO, EmailNotification.class, "sendSimpleMailMessage", null, null, null);
        }
    }

    private String getTemplateEmail() {
        return null;
    }

    public void sendSuccess() {
        Email email = new EmailSupport().getOrderSuccess();
        try {
            this.sendMimeMailMessage(email);
        } catch (MailConnectException | UnknownHostException e) {
            logs.error(HttpStatus.BAD_REQUEST, EMAIL_NAO_ENVIADO + ", " + email, EmailNotification.class, "sendSimpleMailMessage", e, null, null);
        }
    }

    public void sendError(HttpStatus status, Object message, Class<?> clazz, String method, Exception e) {
        Email email = new EmailSupport().getDefaultError(status, message, clazz, method, e);
        this.sendSimpleMailMessage(email);
    }

    public void sendError(HttpStatus status, Object message, Class<?> clazz, String method, Exception e, WebRequest request) {
        Email email = new EmailSupport().getDefaultError(status, message, clazz, method, e, request);
        this.sendSimpleMailMessage(email);
    }

}
