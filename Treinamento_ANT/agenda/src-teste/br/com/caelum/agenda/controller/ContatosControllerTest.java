package br.com.caelum.agenda.controller;

import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.agenda.controller.ContatosController;
import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;

public class ContatosControllerTest {

	private ContatosController controller;
	
	@Mock
	private ContatoDao dao;
	private Result result;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.result = new MockResult();
		this.controller = new ContatosController(dao, result);
	}
	
	@Test
	public void salvandoContato() {
		final Contato contato = new Contato();
		contato.setNome("Madruga");
		contato.setTelefone("1111-2222");

		this.controller.salvar(contato);

		verify(this.dao, atMost(1)).salvar(contato);
	}
	
	@Test
	public void listarContatos() {
		this.controller.listar();
		verify(this.dao, atMost(1)).listar();
	}	
}