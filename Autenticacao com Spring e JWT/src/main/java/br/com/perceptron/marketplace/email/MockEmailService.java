package br.com.perceptron.marketplace.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;

@Slf4j
public class MockEmailService extends AbstractEmailService {

    @Override
    public void send(SimpleMailMessage msg) {
        log.info("Simulando envio de e-mail.");
        log.info(msg.toString());
        log.info("e-mail enviado com sucesso.");

    }


}
