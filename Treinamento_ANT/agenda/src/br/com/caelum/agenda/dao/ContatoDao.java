package br.com.caelum.agenda.dao;

import java.util.List;

import br.com.caelum.agenda.modelo.Contato;

public interface ContatoDao {

	public abstract void altera(Contato contato);

	public abstract void deleta(Contato contato);

	public abstract Contato buscarPorId(Integer id);

	public abstract void salvar(Contato contato);

	public abstract List<Contato> listar();

	public abstract int proximaId();

}
