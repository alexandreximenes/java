package br.com.alexandre.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class logout implements Tarefa{
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.getSession().removeAttribute("usuario.logado"); // ou session.invalidate();
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
//		dispatcher.forward(req, resp);
//		
//		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
//		cookie.setMaxAge(0);
//      resp.addCookie(cookie);
//		PrintWriter writer = resp.getWriter();
//		writer.append("<html><body> usuario deslogado </body></html>");
		
//	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().removeAttribute("usuarioLogado"); // ou session.invalidate();
		return "/WEB-INF/paginas/logout.html";
		
		
	}
}
