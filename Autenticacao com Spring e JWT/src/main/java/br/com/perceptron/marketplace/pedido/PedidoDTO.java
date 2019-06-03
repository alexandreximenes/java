package br.com.perceptron.marketplace.pedido;

import br.com.perceptron.marketplace.cliente.ClienteDTO;
import br.com.perceptron.marketplace.pagamento.PagamentoBoletoDTO;
import br.com.perceptron.marketplace.pagamento.PagamentoCartaoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PedidoDTO {

    private Long id;
    private LocalDateTime data;
    private PagamentoCartaoDTO pagamentoCartaoDTO;
    private PagamentoBoletoDTO pagamentoBoletoDTO;
    private ClienteDTO clienteDTO;

    public PedidoDTO(Pedido p) {
        this.data = nonNull(p.getData()) ? p.getData() : null;
        this.clienteDTO = nonNull(p.getCliente()) ? ClienteDTO.get(p.getCliente()) : null;
    }

    public static List<PedidoDTO> get(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
    }

    public static PedidoDTO get(Pedido pedido) {
        return new PedidoDTO(pedido);
    }
}
