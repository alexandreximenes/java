package br.com.perceptron.marketplace.produto;

import br.com.perceptron.marketplace.endereco.Endereco;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {

    @GetMapping
    ResponseEntity<List<Endereco>> findAll() {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
