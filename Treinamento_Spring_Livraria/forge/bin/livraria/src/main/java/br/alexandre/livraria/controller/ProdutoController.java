package br.alexandre.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.alexandre.livraria.daos.ProdutoDAO;
import br.alexandre.livraria.models.Opcao;
import br.alexandre.livraria.models.Produto;

@Controller
@RequestMapping("produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoDAO dao;
	
	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView("produtos/form");
		mav.addObject("tipos", Opcao.values());
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(Produto produto, RedirectAttributes redirectAttributes) {
		System.out.println(produto);
		dao.gravar(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto adicionado com sucesso!");
		return new ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("produtos/lista");
		List<Produto> produtos = dao.listar();
		mav.addObject("produtos", produtos);
		return mav;
	}
}
