package br.com.alexandre.gerenciador.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/executa")
public class Controller extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String tarefa = req.getParameter("tarefa");
		
		if(tarefa == null) throw new IllegalArgumentException("Tarefa não pode ser nula");
		try {
			
			// o nome do package e classe
			
			tarefa = "br.com.alexandre.gerenciador.web." + tarefa;
			
			System.out.println("tarefa : "+ tarefa);
			
			// Cria um tipo de classe com o nome tarefa;
			
			Class<?> tipo = Class.forName(tarefa);
			
			// cria uma nova instancia da classe
			
			Tarefa instancia = (Tarefa) tipo.newInstance();
			
			// chama o metodo da interface e retorna a pagina para ser redirecionada.
			
			String pagina = instancia.executa(req, resp);
			
			System.out.println("pagina: "+ pagina);
			
			req.getRequestDispatcher(pagina).forward(req, resp);

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}

}
