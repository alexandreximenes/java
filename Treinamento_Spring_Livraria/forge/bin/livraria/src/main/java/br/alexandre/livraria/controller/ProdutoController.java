package br.alexandre.livraria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.alexandre.livraria.daos.ProdutoDAO;
import br.alexandre.livraria.infra.FileSave;
import br.alexandre.livraria.models.Opcao;
import br.alexandre.livraria.models.Produto;
import br.alexandre.livraria.validation.ProdutoValidation;

@Controller
@RequestMapping("produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoDAO dao;
	
	@Autowired
	FileSave fileSave;
	
	@org.springframework.web.bind.annotation.InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidation());
		
	}
	@RequestMapping("/form")
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView("produtos/form");
		mav.addObject("tipos", Opcao.values());
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(MultipartFile sumario, @Valid Produto produto, BindingResult results, RedirectAttributes redirectAttributes) {
		
//		System.out.println(sumario.getOriginalFilename());
//		System.out.println(produto);
		
		if(results.hasErrors()) {
			return form();
		}

		String sumarioPath = fileSave.write("arquivo", sumario);
		produto.setSumarioPath(sumarioPath);
		
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
