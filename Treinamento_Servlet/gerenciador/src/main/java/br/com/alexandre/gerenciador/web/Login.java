package br.com.alexandre.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alexandre.gerenciador.Usuario;
import br.com.alexandre.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		PrintWriter writer = resp.getWriter();
		if(usuario != null) {
			Cookie cookie = new Cookie("usuario.logado", email);
			cookie.setMaxAge(100);
			resp.addCookie(cookie);
			writer.println("<html><body> " +email +" logado com sucesso <body></html>");
		}else {
			writer.println("<html><body> usuario invalido! <body></html>");
		}
		
		
	}
}
