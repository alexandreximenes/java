package com.first.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.first.example.model.Pais;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaisController {

    private List<Pais> paises = new ArrayList<>();

    public PaisController(){
        paises = Stream.of(
            Pais.builder().id(1L).nome("Brasil").sigla("BR").build(),
            Pais.builder().id(2L).nome("Estados Unidos").sigla("US").build()
        ).collect(Collectors.toList());

    }

	@GetMapping("/")
	public String home(Model model){
		model.addAttribute("listaPaises", paises);
		return "redirect:/list";
	}

    @GetMapping("/list")
	public String paises(Model model){
    	model.addAttribute("listaPaises", paises);
		return "pais-page";
	}
    
	@GetMapping("/deletar")
	public String hello(@RequestParam Long id){
    	paises.removeIf(p -> p.getId().equals(id));
		return "redirect:/list";
	}

	@PostMapping("/create")
	public String save(Pais pais){

    	pais.setId(paises.size() + 1L);
    	paises.add(pais);
		return "redirect:/list";
	}

	@GetMapping("/prepare-update")
	public String prepareUpdate(@RequestParam Long id, Model model){

		var pais = paises.stream().filter(p -> p.getId().equals(id)).findFirst().get();
		model.addAttribute("paisAtual", pais);
		model.addAttribute("listaPaises", paises);

		return "pais-page";
    }

	@PostMapping("/update/{id}")
	public String update(@PathVariable Long id, Pais paisUpdate){

		var pais = paises.stream().filter(p -> p.getId().equals(id)).findFirst().get();

		pais.setNome(paisUpdate.getNome());
		pais.setSigla(paisUpdate.getSigla());

		return "redirect:/list";
	}
    
}
