package br.com.caelum.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.agenda.modelo.Contato;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class ContatoMemoriaDao implements ContatoDao{

	private final static List<Contato> BANCO = new ArrayList<Contato>();;
	private static int COUNTER = 1;

	@Override
	public List<Contato> listar() {
		return BANCO;
	}

	@Override
	public void salvar(Contato contato) {
		contato.setId(COUNTER++);
		BANCO.add(contato);
	}

	@Override
	public Contato buscarPorId(Integer id) {
		for (Contato contato : BANCO) {
			if(contato.getId().equals(id)) {
				return contato;
			}
		}
		return null;
	}

	@Override
	public void deleta(Contato contato) {
		BANCO.remove(contato);
	}

	@Override
	public void altera(Contato contato) {
		Contato outroContato = this.buscarPorId(contato.getId());
		outroContato.pegaDadosDo(contato);
	}

	@Override
	public int proximaId() {
		return COUNTER;
	}
}