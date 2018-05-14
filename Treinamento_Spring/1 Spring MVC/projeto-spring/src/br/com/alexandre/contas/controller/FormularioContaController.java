package br.com.alexandre.contas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import br.com.alexandre.contas.dao.ContaDAO;
import br.com.alexandre.contas.modelo.Conta;

@Controller
public class FormularioContaController {

	@RequestMapping("/formulario")
	public String formulario() {
		
		return "formulario-conta";
	}
	
	@RequestMapping("/adicionaConta")
	public String adicionaConta(Conta conta) {
		System.out.println(conta.getDescricao() + " adiciona com sucesso");
		
		new ContaDAO().adiciona(conta);
		
		System.out.println(conta);
		
		return "adiciona-conta";
		
	}
	
	@RequestMapping("removeConta")
	public String remove(Conta conta) {
		
		new ContaDAO().remove(conta);
		System.out.println(conta.getId() + " removida com sucesso!");
		return "redirect:listaContas";
	}
	@RequestMapping("/listaContas")
	public String listaTodos(Model mv) {
		
		List<Conta> listaContas = new ContaDAO().lista();
		
		System.out.println("Conta ---------------------"+ listaContas.size());
		listaContas.forEach(System.out::println);
		
		mv.addAttribute("contas", listaContas);// = new ModelAndView("conta/lista");
		//mv.addObject("contas", listaContas);
		
		return "conta/lista";
	}
	
}
