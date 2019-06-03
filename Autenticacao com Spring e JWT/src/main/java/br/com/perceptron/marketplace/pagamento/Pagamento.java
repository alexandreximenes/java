package br.com.perceptron.marketplace.pagamento;

import br.com.perceptron.marketplace.domains.AbstractEntity;
import br.com.perceptron.marketplace.pedido.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public class Pagamento extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    @OneToOne
    private Pedido pedido;

}
