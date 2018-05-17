package br.com.alexandre.contas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alexandre.contas.dao.UsuarioDAO;
import br.com.alexandre.contas.modelo.Usuario;

@Controller
public class UsuarioController {

	@RequestMapping("/login")
	public String formulario() {
		return "usuario/login";
	}
	
	@RequestMapping("/efetuaLogin")
	public String usuarios(Usuario usuario, HttpSession session) {
		boolean existeUsuario = new UsuarioDAO().existeUsuario(usuario);
		if(!existeUsuario) return "redirect:login";
		
		session.setAttribute("usuarioLogado", usuario);
		
		return "redirect:formulario";
		
	}
	
	@RequestMapping("/logout")
	public String deslogar(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
}
