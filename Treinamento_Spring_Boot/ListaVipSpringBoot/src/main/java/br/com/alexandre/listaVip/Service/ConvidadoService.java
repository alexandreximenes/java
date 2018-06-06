package br.com.alexandre.listaVip.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.enviadoremail.EnviadorDeEmail.EmailService;

import br.com.alexandre.listaVip.Model.Convidado;
import br.com.alexandre.listaVip.Repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository repository;
	
	public void salvar(Convidado convidado) {
		repository.save(convidado);
	}
	
	public List<Convidado> obterTodos() {
		return (ArrayList<Convidado>) repository.findAll();
	}
	
	public void EnviarEmail(Convidado convidado, String seuEmail, String suaSenha, String assunto, String mensagem) {
		new EmailService(
				convidado.getNome(), 
				seuEmail, 
				suaSenha, 
				convidado.getEmail(), 
				assunto, 
				mensagem
		).enviar();
	};

}
