package br.com.perceptron.marketplace.endereco;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/enderecos")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnderecoController {

    private final EnderecoService service;

    @GetMapping("/{cep}")
    public ResponseEntity<Object> findAll(@PathVariable String cep) {
        return service.findViaCep(cep);
    }
}
