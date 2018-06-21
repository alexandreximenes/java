package br.com.alexandre.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alexandre.springboot.dao.ConvidadoRepository;
import br.com.alexandre.springboot.model.Convidado;

@Controller
public class IndexController {
	
	@Autowired
	ConvidadoRepository repository;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("lista")
	public String getConvidados() {
		return "listaconvidados";
	}
	
	@RequestMapping("cadastrar")
	public String cadastrar(Convidado convidado) {
		
		System.out.println(convidado.getNome());
		Iterable<Convidado> findAll = repository.findAll();
		
		return "redirect:lista";
	}


}
