package br.com.alexandre.contas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alexandre.contas.dao.ContaDAO;
import br.com.alexandre.contas.modelo.Conta;

@Controller
public class ContaController {
	
	private ContaDAO dao;

	@Autowired
	public ContaController(ContaDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/formulario")
	public String formulario() {
		
		return "formulario-conta";
	}
	
	@RequestMapping("/adicionaConta")
	public String adicionaConta(@Valid Conta conta, BindingResult result) {

		if(result.hasErrors()) {
			return "formulario-conta";
		}
		
		System.out.println(conta.getDescricao() + " adiciona com sucesso");
		
		dao.adiciona(conta);
		
		System.out.println(conta);
		
		return "redirect:listaContas";
		
	}
	
	@RequestMapping("pagaConta")
	public String pagar(Long id, HttpServletResponse response) {
		
		dao.paga(id);
		
		response.setStatus(200);
		
		return "redirect:listaContas";
	}
	
	@RequestMapping("removeConta")
	public String remove(Conta conta) {
		
		dao.remove(conta);
		System.out.println(conta.getId() + " removida com sucesso!");
		//return "forward:listaContas";
		return "redirect:listaContas";
	}
	
	
	@RequestMapping("/listaContas")
	public String listaTodos(Model mv) {
		
		List<Conta> listaContas = dao.lista();
		
		System.out.println("Conta ---------------------"+ listaContas.size());
		listaContas.forEach(System.out::println);
		
		mv.addAttribute("contas", listaContas);// = new ModelAndView("conta/lista");
		//mv.addObject("contas", listaContas);
		
		return "conta/lista";
	}
	
}
