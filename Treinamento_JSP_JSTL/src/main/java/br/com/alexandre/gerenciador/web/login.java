package br.com.alexandre.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

/**
 * Servlet implementation class login
 */
public class login implements Tarefa {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		Usuario usuarioLogado = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		if(usuarioLogado != null) {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuarioLogado);
			session.setMaxInactiveInterval(10*60);
		}
		return "index.jsp";
	}
		
}
