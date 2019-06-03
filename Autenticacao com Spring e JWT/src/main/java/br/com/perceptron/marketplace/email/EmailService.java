package br.com.perceptron.marketplace.email;

import br.com.perceptron.marketplace.pedido.Pedido;
import br.com.perceptron.marketplace.usuario.Usuario;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

public interface EmailService {

    void send(Pedido pedido);

    default void sendNewPassword(Usuario usuario, String newPassword) {
    }

    default void send(SimpleMailMessage msg) {
    }

    default void sendOrderConfirmationHtmlEmail(Pedido obj) {
    }

    default void sendHtmlEmail(MimeMessage msg) {
    }
}
