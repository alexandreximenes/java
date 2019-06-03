package br.com.perceptron.marketplace.cliente;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/clientes")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController {

    private final ClienteService clientService;

    @GetMapping
    @ApiOperation(value = "Procura todas os clientes cadastrados na base de dados", response = ClienteDTO[].class)
    public ResponseEntity<Object> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/findAllAtivos")
    @ApiOperation(value = "Procura todos os clientes cadastrados que estão ativos na base de dados", response = ClienteDTO[].class)
    public ResponseEntity<Object> findAllAtivos() {
        return clientService.findAllAtivos();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Procura pelo identificador ID", response = ClienteDTO.class)
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        return clientService.deleteById(id);
    }

    @PostMapping
    @ApiOperation(value = "Salva ou edita uma usuário", response = ClienteDTO.class)
    public ResponseEntity<Object> saveOrUpdate(@RequestBody @Valid ClienteDTO clientDTO) {
        return clientService.saveOrUpdate(clientDTO);
    }
}
