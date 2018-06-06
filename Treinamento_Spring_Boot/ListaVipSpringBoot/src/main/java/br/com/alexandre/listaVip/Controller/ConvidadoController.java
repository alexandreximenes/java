package br.com.alexandre.listaVip.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alexandre.listaVip.Model.Convidado;
import br.com.alexandre.listaVip.Service.ConvidadoService;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoService service;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	} 
	
	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {
		
		List<Convidado> convidados = service.obterTodos();
		
		if(!convidados.isEmpty())
			model.addAttribute("convidados", convidados);
		
		return "listaconvidados";
	}
	
	@RequestMapping(value="salvar", method = RequestMethod.POST)
	public String salvar(Convidado convidado) {
		System.out.println(convidado);
		
		service.salvar(convidado);
		
		//service.EnviarEmail(convidado, "seuEmail@servidor.com", "suaSenha", "assunto", "mensagem");
		
		return "redirect:listaconvidados";
		
	}
}
