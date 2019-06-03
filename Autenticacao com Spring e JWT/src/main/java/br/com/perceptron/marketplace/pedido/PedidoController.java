package br.com.perceptron.marketplace.pedido;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(description = "Controlador de pedidos")
@RestController
@RequestMapping("api/v1/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    @ApiOperation(value = "Procura todas os pedidos cadastradas na base de dados", response = PedidoDTO[].class)
    public ResponseEntity<Object> findAll() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Procura pelo identificador ID", response = PedidoDTO.class)
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return pedidoService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Remove o pedido pelo identificador ID", response = PedidoDTO.class)
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        return pedidoService.deleteById(id);
    }

    @PostMapping
    @ApiOperation(value = "Salva ou edita uma pedido", response = PedidoDTO.class)
    public ResponseEntity<Object> saveOrUpdate(@RequestBody @Valid PedidoDTO pedidoDTO) {
        return pedidoService.saveOrUpdate(pedidoDTO);
    }
}
