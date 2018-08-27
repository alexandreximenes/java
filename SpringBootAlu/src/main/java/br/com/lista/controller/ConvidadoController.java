package br.com.lista.controller;

import br.com.lista.model.Convidado;
import br.com.lista.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConvidadoController {

    @Autowired
    ConvidadoRepository repository;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("lista")
    public String listaConvidados(Model model){

        Iterable<Convidado> all = repository.findAll();

        model.addAttribute("convidados", all);

        return "listaconvidados";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/salvar")
    public String salvar(Convidado convidado){

        repository.save(convidado);

        return "redirect:lista";
    }
}
