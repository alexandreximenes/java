package br.com.perceptron.marketplace.pagamento;

import br.com.perceptron.marketplace.pedido.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class PagamentoCartao extends Pagamento {

    private Integer quantidadeParcelas;

    public PagamentoCartao(PagamentoCartaoDTO p) {
        super(p.getTipoPagamento(), Pedido.get(p.getPedido()));
        this.setId(p.getId());
        this.quantidadeParcelas = !StringUtils.isEmpty(p.getQuantidadeParcelas()) ? p.getQuantidadeParcelas() : null;
    }

    public static PagamentoCartao get(PagamentoCartaoDTO p) {
        return new PagamentoCartao(p);
    }
}
