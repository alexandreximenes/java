package br.com.alexandre.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alexandre.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		System.out.println(req.getRequestURI());

		//Capturando o usuario da sessao
		
		String usuarioEmail = getUsuario(resp, req);
		System.out.println(usuarioEmail + " no sistema.");

		/*
		 * String requestURI = req.getRequestURI(); StringBuffer requestURL =
		 * req.getRequestURL(); String remoteUser = req.getRemoteUser(); int localPort =
		 * req.getLocalPort(); String authType = req.getAuthType(); AsyncContext
		 * asyncContext = req.getAsyncContext(); String contextPath =
		 * req.getContextPath(); String characterEncoding = req.getCharacterEncoding();
		 * Cookie[] cookies = req.getCookies(); String localAddr = req.getLocalAddr();
		 * String localName = req.getLocalName(); String remoteAddr =
		 * request.getRemoteAddr(); String remoteHost = request.getRemoteHost(); int
		 * remotePort = request.getRemotePort();
		 * 
		 * System.out.println("requestURI "+ requestURI);
		 * System.out.println("requestURL "+ requestURL);
		 * System.out.println("localAddr "+ localAddr); System.out.println("localName "+
		 * localName); System.out.println(); System.out.println("remoteAddr "+
		 * remoteAddr); System.out.println("remoteHost "+ remoteHost);
		 * System.out.println("remotePort "+ remotePort);
		 * 
		 * // System.out.println("\nCookies"); // for(Cookie c : cookies) { //
		 * System.out.println(c.getName()); // }
		 * 
		 * System.out.println("\nHeader names"); Enumeration<String> headerNames =
		 * req.getHeaderNames(); if(headerNames.hasMoreElements()) {
		 * System.out.println(headerNames.nextElement()); } System.out.println();
		 * System.out.println("characterEncoding "+characterEncoding);
		 * System.out.println("contextPath "+contextPath);
		 * System.out.println("asyncContext "+asyncContext);
		 * System.out.println("authType "+authType);
		 * System.out.println("localPort "+localPort);
		 * System.out.println("remoteUser "+remoteUser);
		 */

		// filtro de permissão para continuar a requisição nas paginas
		filterChain.doFilter(request, response);
	}

	private String getUsuario(HttpServletResponse response, HttpServletRequest request) throws IOException {
		String usuario = "<deslogado>";
		
		HttpSession session = request.getSession();
		String id = session.getId();
		int maxInactiveInterval = session.getMaxInactiveInterval();
		Usuario usuarioSessao = (Usuario) session.getAttribute("usuarioLogado");
		if(usuarioSessao == null) {
			return usuario;
		}else {
			return usuarioSessao.getEmail() + " e id = " + id + " e maxInactiveInterval " + maxInactiveInterval;
		}
	}

	//metodo ficava dentro do getUsurio

	//		Cookie cookie = new Cookies(request.getCookies()).getUsuarioLogado();
	//		if(cookie == null ) {
	//			return usuario;
	//		}
	//		usuario = cookie.getValue();
	//		writer.println(usuario + " no sistema.");
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
