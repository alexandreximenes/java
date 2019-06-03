package br.com.perceptron.marketplace.pedido;

import br.com.perceptron.marketplace.cliente.Cliente;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.util.Objects.nonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PedidoServiceFilter {

    public static Pedido get(Pedido pedido, PedidoDTO pedidoDTO) {

        Pedido u = null;

        u = nonNull(pedido) ? pedido : new Pedido();

        if (nonNull(pedidoDTO.getData())) {
            u.setData(pedidoDTO.getData());
        }

        if (nonNull(pedidoDTO.getClienteDTO())) {
            u.setCliente(Cliente.get(pedidoDTO.getClienteDTO()));
        }

        return u;
    }
}
