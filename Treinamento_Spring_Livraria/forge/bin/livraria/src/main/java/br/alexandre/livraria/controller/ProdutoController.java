package br.alexandre.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.alexandre.livraria.daos.ProdutoDAO;
import br.alexandre.livraria.models.Opcao;
import br.alexandre.livraria.models.Produto;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoDAO dao;
	
	@RequestMapping("/cadastrar")
	public String gravar(Produto produto) {
		System.out.println(produto);
		dao.gravar(produto);
	
		return "produtos/ok";
	}
	
	@RequestMapping(value="/produtos", method=RequestMethod.POST)
	public ModelAndView salvaProduto() {
		ModelAndView mav = new ModelAndView("produtos/form");
		mav.addObject("tipos", Opcao.values());
		
		return mav;
	}
	
	@RequestMapping(value="/produtos", method=RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("produtos/lista");
		
		List<Produto> produtos = dao.listar();
		mav.addObject("produtos", produtos);
		
		return mav;
		
	}
}
