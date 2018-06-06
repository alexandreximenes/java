package com.alexandre.enviadoremail.EnviadorDeEmail;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	private String seuEmail = "";
	private String seuPassword = "";
	private String messagem = "";
	private String assunto = "";
	private String nome = "";
	private String emailDestinatario = "";
	
	
	
	public EmailService(String nome, String seuEmail, String seuPassword, String emailDestinatario, String assunto, String mensagem) {
		this.nome = nome;
		this.seuEmail = seuEmail;
		this.seuPassword = seuPassword;
		this.emailDestinatario = emailDestinatario;
		this.assunto = assunto;
		this.messagem = mensagem;
	}



	public void enviar(){
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(seuEmail, seuPassword));
			email.setSSLOnConnect(true);
	
			email.setFrom(seuEmail);
			email.setSubject(assunto);
			email.addTo(emailDestinatario);
			email.setMsg("Olá " + nome + ". \n" + messagem);
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

}
