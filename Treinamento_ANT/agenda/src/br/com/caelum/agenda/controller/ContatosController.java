package br.com.caelum.agenda.controller;

import java.util.List;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class ContatosController {

	private final ContatoDao contatoDao;
	private final Result result;

	public ContatosController(ContatoDao contatoDao, Result result) {
		this.contatoDao = contatoDao;
		this.result = result;
	}
	
	@Get
	@Path("/contato/novo")
	public void novo() {
	}
	
	@Get
	@Path("/contato/{id}/editar")
	public void editar(Integer id) {
		Contato contato = contatoDao.buscarPorId(id);
		result.include("contato",contato);
	}
	
	@Get
	@Path("/contato")
	public List<Contato> listar() {
		return contatoDao.listar();
	}
	
	@Post
	@Path("/contato")
	public void salvar(Contato contato) {
		contatoDao.salvar(contato);
		redirecionaParaOListar();
	}
	
	@Get
	@Path("/contato/{id}")
	public Contato exibir(Integer id) {
		return contatoDao.buscarPorId(id);
	}
	
	@Put
	@Path("/contato")
	public void alterar(Contato contato) {
		contatoDao.altera(contato);
		redirecionaParaOListar();
	}
	
	@Get
	@Path("/contato/{id}/deletar")
	public void deletar(Integer id) {
		Contato contato = contatoDao.buscarPorId(id);
		contatoDao.deleta(contato);

		redirecionaParaOListar();
	}
	
	@Get
	@Path("/contato/randomData")
	public void randomData() {
		
		int proximaId = contatoDao.proximaId();

		for(int i = proximaId; i <= (proximaId + 9); i++) {
			Contato contato = new Contato();
			contato.setNome("contato " + i);
			contato.setTelefone("88889999");
			contatoDao.salvar(contato);
		}
		
		redirecionaParaOListar();
	}
	
	private void redirecionaParaOListar() {
		result.redirectTo(this).listar();
	}
}
