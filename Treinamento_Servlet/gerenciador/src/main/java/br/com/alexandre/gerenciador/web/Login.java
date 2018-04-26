package br.com.alexandre.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alexandre.gerenciador.Usuario;
import br.com.alexandre.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		pagina /login é acessado via post, caso acesse via get é causado erro
//		neste caso, esta direcionando para ela mesmo, caso alguem tente acessar via get
		req.getRequestDispatcher("index.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		PrintWriter writer = resp.getWriter();
		
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		if(usuario == null) { 
			writer.println("<html><body> Usuario invalido ! </body></html>"); 
		}else {
			//Trabalhando com Session
			HttpSession session = req.getSession();
			session.setMaxInactiveInterval(60*10);		
			session.setAttribute("usuario.logado", usuario);
			writer.println("<html><body> "+ usuario.getEmail() +" logado com sucesso ! </body></html>");
		}
	}		
		
		

	//cookies
	
	//getCookie(resp, email, usuario);
	/*private void getCookie(HttpServletResponse resp, String email, Usuario usuario) throws IOException {
		PrintWriter writer = resp.getWriter();
		if (usuario != null) {
			Cookie cookie = new Cookie("usuario.logado", email);
			cookie.setMaxAge(60*10);
			//cookie.setSecure(true);
			resp.addCookie(cookie);
			writer.println("<html><body> " + email + " logado com sucesso </body></html>");
		} else {
			writer.println("<html><body> usuario invalido! </body></html>");
		}
	}*/
}
