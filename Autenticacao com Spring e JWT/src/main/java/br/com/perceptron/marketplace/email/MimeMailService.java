package br.com.perceptron.marketplace.email;

import br.com.perceptron.marketplace.pedido.Pedido;
import br.com.perceptron.marketplace.usuario.Usuario;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Service
public class MimeMailService {

    public MimeMessage prepare(JavaMailSender javaMailSender, TemplateEngine templateEngine, String from, String to, String subject, Usuario usuario, String newPassword) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setSentDate(new Date());
        mimeMessageHelper.setText(sendNewPasswordMimeMailMessage(templateEngine, usuario.getNome(), newPassword), true);
        mimeMessageHelper.setTo(usuario.getUsername());
        return mimeMessage;
    }

    private String sendOrderConfirmationMimeMailMessage(TemplateEngine templateEngine, Pedido pedido) {
        Context context = new Context();
        context.setVariable("pedido", pedido);
        return templateEngine.process("email/confirmacao-pedido", context);
    }

    private String sendNewPasswordMimeMailMessage(TemplateEngine templateEngine, String nomeUsuario, String newPassword) {
        Context context = new Context();
        context.setVariable("nomeUsuario", nomeUsuario);
        context.setVariable("novaSenha", newPassword);
        return templateEngine.process("email/send-new-password", context);
    }
}
