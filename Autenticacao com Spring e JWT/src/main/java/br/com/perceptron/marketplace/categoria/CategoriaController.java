package br.com.perceptron.marketplace.categoria;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Api(description = "Controlador da categoria")
@RestController
@RequestMapping("api/v1/categorias")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CategoriaController {
    private final CategoriaService service;

    @GetMapping
    @ApiParam(value = "Retorna todas as categorias existentes para cadastrar produtos, com paginacao padrao de 10 elementos por pagina")
    public ResponseEntity<Object> findAll(HttpServletRequest request, @RequestParam(value = "pagina", defaultValue = "0", required = false) Integer pagina,
                                          @RequestParam(value = "quantidade", defaultValue = "10", required = false) Integer quantidade,
                                          @RequestParam(value = "ordenarPor", defaultValue = "nome", required = false) String ordenarPor,
                                          @RequestParam(value = "direcaoOrdenacao", defaultValue = "ASC", required = false) String direcaoOrdenacao,
                                          @RequestParam(value = "buscarPor", defaultValue = "", required = false) String parametro) {
        return service.findAll(pagina, quantidade, ordenarPor, direcaoOrdenacao, parametro);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna a categoria pelo identificador ID")
    @ApiParam(value = "Retorna as categoria pelo identificador ID")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ApiParam(value = "Retorna a categoria pelo identificador ID")
    public ResponseEntity<Object> saveOrUpdate(@Valid @RequestBody CategoriaDTO categoryDTO) {
        return service.saveOrUpdate(categoryDTO);
    }

    @DeleteMapping("/{id}")
    @ApiParam(value = "Remove uma categoria pelo identificador ID")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        return service.deleteById(id);
    }
}
