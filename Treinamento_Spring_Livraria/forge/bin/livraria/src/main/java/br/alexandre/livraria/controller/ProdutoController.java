package br.alexandre.livraria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.alexandre.livraria.model.Produto;

@Controller
public class ProdutoController {
	
	@RequestMapping("/produtos/form")
	public String salvaProduto(Produto produto) {
		return "produtos/form";
	}
	
	@RequestMapping("/produtos")
	public String grava(Produto produto) {

		System.out.println(produto);
		
		return "produtos/ok";
	}
}
