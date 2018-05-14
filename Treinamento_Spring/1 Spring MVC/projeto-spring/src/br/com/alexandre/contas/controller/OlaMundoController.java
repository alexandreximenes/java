package br.com.alexandre.contas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {
	
	@RequestMapping("/olaMundoSpring")
	public String execute() {
		
		System.out.println("Excecutando uma logica com String MVC");
		
		return "ok";
	}
}
