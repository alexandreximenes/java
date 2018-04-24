package br.com.alexandre.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {

	private Cookie[] cookies;

	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;
	}

	public Cookie getUsuarioLogado() {
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("usuario.logado")) {
					return cookie;
				}
			}
		}
		return null;
	}

	
}
