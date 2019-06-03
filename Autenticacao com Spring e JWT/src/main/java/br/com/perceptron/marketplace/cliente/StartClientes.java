package br.com.perceptron.marketplace.cliente;

import br.com.perceptron.marketplace.endereco.Endereco;
import br.com.perceptron.marketplace.endereco.EnderecoRepository;
import br.com.perceptron.marketplace.response.ResponseDTO;
import br.com.perceptron.marketplace.usuario.Usuario;
import br.com.perceptron.marketplace.usuario.UsuarioRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static br.com.perceptron.marketplace.response.ResponseUtils.*;
import static java.util.Objects.isNull;

public class StartClientes {

    private ResponseDTO<Usuario> responseDTO = new ResponseDTO<>();
    private ClienteRepository clienteRepository;
    private EnderecoRepository enderecoRepository;
    private UsuarioRepository usuarioRepository;

    public StartClientes(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository, UsuarioRepository usuarioRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.usuarioRepository = usuarioRepository;
        insertData();
    }

    @Transactional
    public Cliente insertData() {

        try {

            Endereco endereco = null;
            Optional<Endereco> enderecoOp = enderecoRepository.findByCepAndLogradouroAndNumero("81920650", "Rua nova aurora", "1689");
            if (enderecoOp.isPresent())
                endereco = enderecoOp.get();

            TipoCliente pessoaFisica = TipoCliente.PESSOA_FISICA;

            Set<String> telefones = new HashSet<>();
            telefones.add("41 99999999");
            telefones.add("41 88888888");

            Set<String> emails = new HashSet<>();
            emails.add("maria@maria.com");

            Usuario usuario = null;
            Optional<Usuario> usuarioOp = usuarioRepository.findByUsername("xyymenes@gmail.com");
            if (usuarioOp.isPresent())
                usuario = usuarioOp.get();

            String codigo = "001";
            Cliente cliente = clienteRepository.findByCodigo(codigo);
            if (isNull(cliente)) {
                cliente = new Cliente("Maria", codigo, endereco, pessoaFisica, true, null, telefones, emails, usuario);
            }

            responseDTO.success($200, CLIENTE + SALVO, this.getClass());
            return clienteRepository.save(cliente);

        } catch (Exception e) {
            responseDTO.error($404, NAO_SALVO + CLIENTE, this.getClass(), "insertData", e);
        }

        return null;
    }
}
