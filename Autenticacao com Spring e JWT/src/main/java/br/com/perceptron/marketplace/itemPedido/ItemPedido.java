package br.com.perceptron.marketplace.itemPedido;

import br.com.perceptron.marketplace.domains.AbstractEntity;
import br.com.perceptron.marketplace.pedido.Pedido;
import br.com.perceptron.marketplace.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class ItemPedido extends AbstractEntity {

    private BigDecimal desconto;
    private BigDecimal preco;
    private Integer quantidade;

    @ManyToOne
    private Produto produto;
    @ManyToOne
    private Pedido pedido;

    public ItemPedido(BigDecimal desconto, Integer quantidade, BigDecimal preco) {
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Double getSubTotal() {
        return preco.subtract(desconto).multiply(BigDecimal.valueOf(quantidade)).doubleValue();
    }

    @Override
    public String toString() {
        return "\n" +
                "\ndesconto: " + desconto +
                "\npreco: " + preco +
                "\nquantidade: " + quantidade +
                "\nproduto: " + produto;
    }
}
