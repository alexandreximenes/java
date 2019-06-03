package br.com.perceptron.marketplace.produto;

import br.com.perceptron.marketplace.categoria.Categoria;
import br.com.perceptron.marketplace.domains.AbstractEntity;
import br.com.perceptron.marketplace.itemPedido.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Produto extends AbstractEntity {

    @NotEmpty
    private String nome;
    private BigDecimal preco;

    public Produto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @ManyToOne
    private Categoria categoria;

    @OneToMany(mappedBy = "produto")
    private List<ItemPedido> itensPedido;


    @Override
    public String toString() {
        return "\n" +
                "\nnome: " + nome +
                "\npreço: " + preco;
    }
}
