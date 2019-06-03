package br.com.perceptron.marketplace.usuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Api
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    @Autowired
    public UsuarioController(UsuarioService usarioService) {
        this.userService = usarioService;
    }

    @GetMapping
    @ApiOperation(value = "Procura todas os usuários cadastradas na base de dados", response = UsuarioDTO[].class)
    public ResponseEntity<Object> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findAllAtivos")
    @ApiOperation(value = "Procura todas os usuários cadastradas que estão ativos na base de dados", response = UsuarioDTO[].class)
    public ResponseEntity<Object> findAllAtivos() {
        return userService.findAllAtivos();
    }

    @PostMapping(path = "/authentication")
    @ApiOperation(value = "Faz login do usuário no sistema", response = UsuarioDTO.class)
    public ResponseEntity<Object> auth(@Valid @RequestBody LoginDTO loginDTO) {
        return userService.authentication(loginDTO);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Procura pelo identificador ID", response = UsuarioDTO.class)
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/findTokenToCurrentUser")
    @ApiOperation(value = "Recupera o token do usuário corrente", response = TokenDTO.class)
    public ResponseEntity<Object> findTokenToCurrentUser() {
        return userService.findTokenToCurrentUser();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }

    @PostMapping
    @ApiOperation(value = "Salva ou edita uma usuário", response = UsuarioDTO.class)
    public ResponseEntity<Object> saveOrUpdate(@RequestBody @Valid UsuarioDTO usuarioVO) {
        return userService.saveOrUpdate(usuarioVO);
    }

    @PostMapping
    @ApiOperation(value = "Refresh token", response = TokenDTO.class)
    public ResponseEntity<Object> refreshToken(HttpServletResponse response) {
        return userService.refreshToken(response);
    }

    @PostMapping
    @ApiOperation(value = "Envia novo password para o email da pessoa", response = String.class)
    public ResponseEntity<Object> sendNewPassword(@PathVariable String email) {
        return userService.sendNewPassword(email);
    }


}
