package br.com.alexandre.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= "/logout")
public class Logout extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
		PrintWriter writer = resp.getWriter();
		if(cookie == null) {
			writer.println("<html><body>O usuario não estava logado</body></html>");
			return;
		}
		cookie.setMaxAge(0);
		resp.setStatus(200);
		resp.addCookie(cookie);
		writer.println("<html><body> Usuario desgado com sucesso! </body></html>");
		
	}
}
