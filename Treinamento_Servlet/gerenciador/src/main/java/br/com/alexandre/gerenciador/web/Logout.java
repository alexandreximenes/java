package br.com.alexandre.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alexandre.gerenciador.Usuario;

public class Logout implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {

		HttpSession session = req.getSession();
		
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		if(usuario == null) {
			req.setAttribute("log", "O usuario não estava logado");
			return "/WEB-INF/paginas/logout.jsp";
		}else {
			//remove o usuario da sessão.
			session.removeAttribute("usuarioLogado");
			req.setAttribute("log", "Usuário deslogado no sistema");
		
			return "/WEB-INF/paginas/logout.jsp";
		
		}
		
		
	}
}
		
		
		
		
		
		
			//Redirecionando paginas
			//resp.sendRedirect("paginas/logout.html");
			
			// Tira tudo que existe na sessão
			//session.invalidate();
		
			//writer.println("<html><body> Usuario desgado com sucesso! </body></html>");
		
		/*Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
		PrintWriter writer = resp.getWriter();
		if(cookie == null) {
			writer.println("<html><body>O usuario não estava logado</body></html>");
			return;
		}
		cookie.setMaxAge(0);
		resp.setStatus(200);
		resp.addCookie(cookie);
		writer.println("<html><body> Usuario desgado com sucesso! </body></html>");*/
		
