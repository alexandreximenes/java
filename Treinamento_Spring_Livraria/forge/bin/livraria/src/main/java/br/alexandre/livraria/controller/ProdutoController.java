package br.alexandre.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.alexandre.livraria.daos.ProdutoDAO;
import br.alexandre.livraria.models.Produto;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoDAO dao;
	
	@RequestMapping("/produtos")
	public String salvaProduto(Produto produto) {
		return "produtos/form";
	}
	
	@RequestMapping("/cadastrar")
	public String gravar(Produto produto) {
		System.out.println(produto);
		dao.gravar(produto);
	
		return "produtos/ok";
	}
}
