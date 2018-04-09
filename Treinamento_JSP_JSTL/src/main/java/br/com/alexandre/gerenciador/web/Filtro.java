package br.com.alexandre.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class Filtro implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		String requestURI = req.getRequestURI();
		
		String usuario = getUsuario(req, requestURI);//getCookie(req, requestURI);
		if(usuario != null) {
			chain.doFilter(request, response);
		}
	}

	private String getUsuario(HttpServletRequest req, String requestURI) {
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario.logado");
		if(usuario != null) {
			System.out.println("usuario " +usuario.getEmail() + "acessando a URL " +requestURI);
			if(usuario != null) return usuario.getEmail();
		}
		return "<deslogado>";
	}

//	private String getCookie(HttpServletRequest req, String requestURI) {
//		String usuario = "<deslogado>";
//		Cookie cookies = new Cookies(req.getCookies()).buscaUsuarioLogado();
//		if(cookies != null) {
//			System.out.println("usuario " +cookies.getValue() + "acessando a URL " +requestURI);	
//			}
//		return cookies.getValue();	
//	}
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
