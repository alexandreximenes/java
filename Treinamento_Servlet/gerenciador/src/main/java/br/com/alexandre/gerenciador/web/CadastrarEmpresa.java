package br.com.alexandre.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alexandre.gerenciador.Empresa;
import br.com.alexandre.gerenciador.dao.EmpresaDAO;

public class CadastrarEmpresa implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String nome = req.getParameter("empresa");
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		
		req.setAttribute("empresa", empresa);

		return "/WEB-INF/paginas/cadastrar-empresa.jsp";
	}

}