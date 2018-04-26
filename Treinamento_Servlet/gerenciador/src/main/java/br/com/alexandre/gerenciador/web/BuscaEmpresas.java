package br.com.alexandre.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alexandre.gerenciador.Empresa;
import br.com.alexandre.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/busca-empresa")
public class BuscaEmpresas extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public BuscaEmpresas() {
		System.out.println("Construindo uma servlet " + this);
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Inicializando a servlet " + this);
			
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destruindo a servlet " + this);
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String filtro = req.getParameter("filtro");
			Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
			req.setAttribute("empresas", empresas);
			
			req.getRequestDispatcher("/WEB-INF/paginas/busca-empresa.jsp").forward(req, resp);
			
			
			
//			PrintWriter writer = resp.getWriter();
//			writer.println("<html><body>");
//			
//			writer.println("<ul>");
//			for(Empresa empresa : empresas) {
//				writer.println("<li>");
//				writer.println(empresa.getId() +" - " + empresa.getNome() );
//				writer.println("</li>");
//			}
//			writer.println("</ul>");
//		writer.println("</body></html>");
	}
}
