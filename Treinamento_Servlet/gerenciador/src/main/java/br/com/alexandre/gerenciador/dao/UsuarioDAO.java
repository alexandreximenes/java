package br.com.alexandre.gerenciador.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.alexandre.gerenciador.Usuario;

public class UsuarioDAO {

	private final static Map<String, Usuario> USUARIOS = new HashMap<>();
	static {
		USUARIOS.put("xyymenes@gmail.com", new Usuario("xyymenes@gmail.com.br","alexandre1"));
		USUARIOS.put("x0menes@gmail.com", new Usuario("x0menes@gmail.com","alexandre2"));
	}

	public Usuario buscaPorEmailESenha(String email, String senha) {
		if (!USUARIOS.containsKey(email))
			return null;

		Usuario usuario = USUARIOS.get(email);
		if (usuario.getSenha().equals(senha))
			return usuario;
		
		return null;
	}

}
