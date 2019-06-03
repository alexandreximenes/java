package br.com.perceptron.marketplace.pedido;

import br.com.perceptron.marketplace.cliente.Cliente;
import br.com.perceptron.marketplace.domains.AbstractEntity;
import br.com.perceptron.marketplace.itemPedido.ItemPedido;
import br.com.perceptron.marketplace.utils.DateUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Pedido extends AbstractEntity {

    private LocalDateTime data;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedido;

    public Pedido(PedidoDTO p) {
        this.data = nonNull(p.getData()) ? p.getData() : null;
        this.cliente = nonNull(p.getClienteDTO()) ? Cliente.get(p.getClienteDTO()) : null;
    }

    public Pedido(LocalDateTime data, Cliente cliente) {
        this.data = data;
        this.cliente = cliente;
    }

    public Double geTotal() {
        return itensPedido.stream().mapToDouble(ItemPedido::getSubTotal).sum();
    }

    public static List<Pedido> get(List<PedidoDTO> pedidosDTO) {
        return pedidosDTO.stream().map(Pedido::new).collect(Collectors.toList());
    }

    public static Pedido get(PedidoDTO pedido) {
        return new Pedido(pedido);
    }

    @Override
    public String toString() {
        return "Pedido : " +
                "\ndata: " + DateUtils.toBR(data) +
                "\ncliente: " + cliente +
                "\nitens do pedido: " + itensPedido;
    }
}
