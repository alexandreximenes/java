package br.com.perceptron.marketplace.bootstrap;

import br.com.perceptron.marketplace.categoria.CategoriaRepository;
import br.com.perceptron.marketplace.categoria.StartCategorias;
import br.com.perceptron.marketplace.cliente.ClienteRepository;
import br.com.perceptron.marketplace.cliente.StartClientes;
import br.com.perceptron.marketplace.endereco.EnderecoRepository;
import br.com.perceptron.marketplace.endereco.StartEnderecos;
import br.com.perceptron.marketplace.itemPedido.ItemPedidoRepository;
import br.com.perceptron.marketplace.paginacao.PagamentoBoletoRepository;
import br.com.perceptron.marketplace.pedido.PedidoRepository;
import br.com.perceptron.marketplace.pedido.StartPedido;
import br.com.perceptron.marketplace.produto.ProdutoRepository;
import br.com.perceptron.marketplace.produto.StartProdutos;
import br.com.perceptron.marketplace.usuario.StartUsuarios;
import br.com.perceptron.marketplace.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DBService {

    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtosRepository;
    private final UsuarioRepository usuarioRepository;
    private final EnderecoRepository enderecoRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final PagamentoBoletoRepository pagamentoBoletoRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void init() {
        new StartCategorias(categoriaRepository);
        new StartProdutos(categoriaRepository, produtosRepository);
        new StartUsuarios(usuarioRepository, bCryptPasswordEncoder);
        new StartEnderecos(enderecoRepository);
        new StartClientes(clienteRepository, enderecoRepository, usuarioRepository);
        new StartPedido(pedidoRepository, usuarioRepository, clienteRepository, enderecoRepository, produtoRepository, itemPedidoRepository, pagamentoBoletoRepository);
    }


}
