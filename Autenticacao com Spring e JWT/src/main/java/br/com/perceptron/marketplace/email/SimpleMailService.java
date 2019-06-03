package br.com.perceptron.marketplace.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SimpleMailService {

    public SimpleMailMessage prepare(String from, String to, String subject, String text) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(from);
        sm.setFrom(to);
        sm.setSubject(subject);
        sm.setSentDate(new Date());
        sm.setText(text);
        return sm;
    }
}
