package br.com.alexandre.gerenciador.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.AsyncContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter  {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String requestURI = req.getRequestURI();
		StringBuffer requestURL = req.getRequestURL();
		String remoteUser = req.getRemoteUser();
		int localPort = req.getLocalPort();
		String authType = req.getAuthType();
		AsyncContext asyncContext = req.getAsyncContext();
		String contextPath = req.getContextPath();
		String characterEncoding = req.getCharacterEncoding();
		Cookie[] cookies = req.getCookies();
		String localAddr = req.getLocalAddr();
		String localName = req.getLocalName();
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		int remotePort = request.getRemotePort();
		
		System.out.println("requestURI "+ requestURI);
		System.out.println("requestURL "+ requestURL);
		System.out.println("localAddr "+ localAddr);
		System.out.println("localName "+ localName);
		System.out.println();
		System.out.println("remoteAddr "+ remoteAddr);
		System.out.println("remoteHost "+ remoteHost);
		System.out.println("remotePort "+ remotePort);
		
//		System.out.println("\nCookies");
//		for(Cookie c : cookies) {
//			System.out.println(c.getName());
//		}
		
		System.out.println("\nHeader names");
		Enumeration<String> headerNames = req.getHeaderNames();
		if(headerNames.hasMoreElements()) {
			System.out.println(headerNames.nextElement());
		}
		System.out.println();	
		System.out.println("characterEncoding "+characterEncoding);
		System.out.println("contextPath "+contextPath);
		System.out.println("asyncContext "+asyncContext);
		System.out.println("authType "+authType);
		System.out.println("localPort "+localPort);
		System.out.println("remoteUser "+remoteUser);
		
		//filtro de permissão para continuar a requisição nas paginas
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
