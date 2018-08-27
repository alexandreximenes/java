package br.com.caelum.agenda.modelo;

import org.junit.Assert;
import org.junit.Test;

public class ContatoTest {

	@Test
	public void pegaDadosDoOutroContato() {
		Contato outro = new Contato();
		outro.setNome("Madruga");
		outro.setTelefone("1111-2222");

		Contato contato = new Contato();
		contato.pegaDadosDo(outro);

		Assert.assertEquals(contato.getNome(), outro.getNome());
		Assert.assertEquals(contato.getTelefone(), outro.getTelefone());
	}

}