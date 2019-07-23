package br.com.perceptron.marketplace.pedido;

import br.com.perceptron.marketplace.cliente.Cliente;
import br.com.perceptron.marketplace.cliente.ClienteRepository;
import br.com.perceptron.marketplace.cliente.StartClientes;
import br.com.perceptron.marketplace.endereco.EnderecoRepository;
import br.com.perceptron.marketplace.itemPedido.ItemPedido;
import br.com.perceptron.marketplace.itemPedido.ItemPedidoRepository;
import br.com.perceptron.marketplace.pagamento.PagamentoBoleto;
import br.com.perceptron.marketplace.pagamento.TipoPagamento;
import br.com.perceptron.marketplace.paginacao.PagamentoBoletoRepository;
import br.com.perceptron.marketplace.produto.Produto;
import br.com.perceptron.marketplace.produto.ProdutoRepository;
import br.com.perceptron.marketplace.response.ResponseDTO;
import br.com.perceptron.marketplace.usuario.UsuarioRepository;
import br.com.perceptron.marketplace.utils.DateUtils;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.perceptron.marketplace.response.ResponseUtils.*;
import static java.util.Arrays.asList;
import static java.util.Objects.nonNull;

public class StartPedido {

    private ResponseDTO<Pedido> responseDTO = new ResponseDTO<>();
    private PedidoRepository pedidoRepository;
    private UsuarioRepository usuarioRepository;
    private ClienteRepository clienteRepository;
    private EnderecoRepository enderecoRepository;
    private ProdutoRepository produtoRepository;
    private ItemPedidoRepository itemPedidoRepository;
    private PagamentoBoletoRepository pagamentoBoletoRepository;

    public StartPedido(PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository, ClienteRepository clienteRepository, EnderecoRepository enderecoRepository, ProdutoRepository produtoRepository, ItemPedidoRepository itemPedidoRepository, PagamentoBoletoRepository pagamentoBoletoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.produtoRepository = produtoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
        this.pagamentoBoletoRepository = pagamentoBoletoRepository;
        insertData();
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertData() {
        try {

            Cliente maria = findOrNewCliente(usuarioRepository, clienteRepository, enderecoRepository);
            clienteRepository.save(maria);

            Produto produto = produtoRepository.findByNomeContainingIgnoreCase("Cadeira").orElse(null);
            List<Produto> produtos = produtoRepository.findAll().stream().limit(3).collect(Collectors.toList());

            Pedido pedido = new Pedido(LocalDateTime.now(), maria);
            pedido.setCliente(maria);
            Pedido pedidoSalvo = pedidoRepository.save(pedido);

            PagamentoBoleto pagamentoBoleto = new PagamentoBoleto(DateUtils.hoje(), DateUtils.addDias(30));
            pagamentoBoleto.setTipoPagamento(TipoPagamento.PENDENTE);
            pagamentoBoleto.setPedido(pedidoSalvo);
            pagamentoBoletoRepository.save(pagamentoBoleto);


            BigDecimal preco = nonNull(produto) && nonNull(produto.getPreco()) ? produto.getPreco() : new BigDecimal(1.0);

            ItemPedido itemPedido = new ItemPedido(new BigDecimal("10.00"), 5, preco);
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);

            ItemPedido itemPedido2 = new ItemPedido(new BigDecimal("20.00"), 10, preco);
            itemPedido2.setPedido(pedido);
            itemPedido2.setProduto(produto);

            ItemPedido itemPedido3 = new ItemPedido(new BigDecimal("30.00"), 15, preco);
            itemPedido3.setPedido(pedido);
            if (!produtos.isEmpty())
                itemPedido3.setProduto(produtos.get(1));

            ItemPedido itemPedido4 = new ItemPedido(new BigDecimal("40.00"), 20, preco);
            itemPedido4.setPedido(pedido);
            if (!produtos.isEmpty() && produtos.size() >= 2)
                itemPedido4.setProduto(produtos.get(2));

            ItemPedido itemPedido5 = new ItemPedido(new BigDecimal("50.00"), 25, preco);
            itemPedido5.setPedido(pedido);
            itemPedido4.setProduto(produto);

            itemPedidoRepository.saveAll(asList(itemPedido, itemPedido2, itemPedido3, itemPedido4, itemPedido5));

            responseDTO.success($200, OBJETO_SALVO_COM_SUCESSO, this.getClass());
        } catch (Exception e) {
            responseDTO.error($404, OBJETO_NAO_ENCONTRADO, this.getClass(), "insertData", e);
        }
    }

    private Cliente findOrNewCliente(UsuarioRepository usuarioRepository, ClienteRepository clienteRepository, EnderecoRepository enderecoRepository) {
        return clienteRepository.findByNomeContaining("Maria")
                .orElse(new StartClientes(clienteRepository, enderecoRepository, usuarioRepository).insertData());
    }
}
