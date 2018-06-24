package br.com.alexandre.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String getConvidados(Model model) {
		
		Iterable<Convidado> convidados = repository.findAll();
		if(convidados != null) {
			model.addAttribute("convidados", convidados);
		}

		return "listaconvidados";
	}
	
	@RequestMapping(value="cadastrar", method=RequestMethod.POST)
	public String cadastrar(Convidado convidado) {
		
		System.out.println(convidado.getNome());
		
		repository.save(convidado);
		
		return "redirect:lista";
	}


}
