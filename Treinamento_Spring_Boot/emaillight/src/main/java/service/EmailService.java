package service;

import model.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class EmailService {
    HtmlEmail html = null;
    public EmailService() {
       html = new HtmlEmail();
    }

    @Autowired
    private Email email;

    public String sendText() {
        return null;
    }

    public String sendHTML() {
        email
             .hostName("smtp.googlemail.com")
                .de("alexandre.ximenes@livetouch.com.br")
                .para("alexandre.ximenes@livetouch.com.br")
                .assunto("Email teste")
                .port(465)
                .htmlMsg("<html><h1>Email Light</h1></br><h2>Enviando email de teste</h2></html>")
                .textMsg("Enviando email de teste");
            send();
        return null;
    }

    private void send(){
        try {
            // Cria o e-mail
            html.setHostName("mail.myserver.com");
            html.addTo("jdoe@somewhere.org", "John Doe");
            html.setFrom("me@apache.org", "Me");
            html.setSubject("Teste de e-mail em formato HTML");

            // adiciona uma imagem ao corpo da mensagem e retorna seu id
            URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
            String cid = html.embed(url, "Apache logo");

            // configura a mensagem para o formato HTML
            html.setHtmlMsg("<html>The apache logo - <img src=\"cid:" + cid + "\"></html>");

            // configure uma mensagem alternativa caso o servidor não suporte HTML
            html.setTextMsg("Seu servidor de e-mail não suporta mensagem HTML");

            // envia o e-mail
            html.send();
        }catch(EmailException e){
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

}
