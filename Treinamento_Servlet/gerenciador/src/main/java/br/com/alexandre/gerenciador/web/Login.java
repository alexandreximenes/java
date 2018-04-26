package br.com.alexandre.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alexandre.gerenciador.Usuario;
import br.com.alexandre.gerenciador.dao.UsuarioDAO;

public class Login implements Tarefa {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp){

		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		if(usuario == null) { 
			req.setAttribute("usuarioInvalido", "usuario Invalido"); 
			
			return "index.jsp";
			
		}else {
			
			//Trabalhando com Session
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);

			return "index.jsp";
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
