package br.com.alexandre.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class BuscaEmpresa implements Tarefa{

	private static final long serialVersionUID = 1L;

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		PrintWriter writer = resp.getWriter();
//		String filtro = req.getParameter("filtro");
//		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
//			
//		req.setAttribute("empresas", empresas);
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/busca-empresa.jsp");
//		dispatcher.forward(req, resp);
//		
//		
////			writer.println("<html><body>");
////			writer.println("<ul>");
////			for (Empresa empresa : empresas) {
////				writer.println("<li>"+ empresa.getId() + " : " + empresa.getNome() +"</li>");
////			}
////			writer.println("</ul>");
////			writer.println("</body></html>");
//	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
			
		req.setAttribute("empresas", empresas);
		return "/WEB-INF/paginas/busca-empresa.jsp";
	}

}
