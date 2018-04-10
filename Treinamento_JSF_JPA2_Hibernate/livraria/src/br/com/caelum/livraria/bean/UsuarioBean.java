package br.com.caelum.livraria.bean;

import javax.faces.bean.ManagedBean;

import br.com.caelum.livraria.dao.UsuarioDAO;
import br.com.caelum.livraria.modelo.Usuario;

@ManagedBean(name = "usuarioBean")
public class UsuarioBean {

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public String logar() {

		boolean existe = new UsuarioDAO().existe(this.usuario);
		System.out.println("fazendo login" + this.usuario.getEmail());
		if (existe) {
			return "livro?faces-redirect=true";

		}
		return null;
	}

}
