package br.com.alexandre.gerenciador.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alexandre.gerenciador.Empresa;
import br.com.alexandre.gerenciador.dao.EmpresaDAO;

public class BuscaEmpresas implements Tarefa{
		
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
			String filtro = req.getParameter("filtro");
			Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
			req.setAttribute("empresas", empresas);
			
			return "/WEB-INF/paginas/busca-empresa.jsp";
			
	}


}
