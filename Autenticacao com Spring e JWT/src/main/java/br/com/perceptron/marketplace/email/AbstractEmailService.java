package br.com.perceptron.marketplace.email;

import br.com.perceptron.marketplace.pedido.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Set;

public abstract class AbstractEmailService implements EmailService {

    @Value("${email.to}")
    private String to;
    @Value("${email.from}")
    private String from;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void send(Pedido pedido) {
        SimpleMailMessage simpleMailMessage = prepareSimpleMailMessage(pedido);
        send(simpleMailMessage);
    }

    private SimpleMailMessage prepareSimpleMailMessage(Pedido pedido) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(to);
        sm.setFrom(from);
        sm.setSubject("Pedido confirmado: " + pedido.getId());
        sm.setSentDate(new Date());
        sm.setText(pedido.toString());
        return sm;
    }

    private String sendOrderConfirmationMimeMailMessage(Pedido pedido) {
        Context context = new Context();
        context.setVariable("pedido", pedido);
        return templateEngine.process("email/confirmacaoPedido", context);
    }

    private void mimeMailMessage(Pedido pedido) {
        MimeMessage mimeMessage = prepareMimeMessage(pedido);
        sendHtmlEmail(mimeMessage);
    }

    protected MimeMessage prepareMimeMessage(Pedido pedido) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        Set<String> emails = pedido.getCliente().getEmails();
        emails.stream().forEach(email -> {
            try {
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
                mimeMessageHelper.setFrom(from);
                mimeMessageHelper.setSubject("Pedido confirmado, codigo " + pedido.getId());
                mimeMessageHelper.setSentDate(new Date());
                mimeMessageHelper.setText(sendOrderConfirmationMimeMailMessage(pedido), true);
                mimeMessageHelper.setTo(email);
            } catch (MessagingException e) {
                send(pedido);
            }

        });
        return mimeMessage;


    }
}
