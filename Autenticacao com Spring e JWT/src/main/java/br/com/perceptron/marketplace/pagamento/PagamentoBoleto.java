package br.com.perceptron.marketplace.pagamento;

import br.com.perceptron.marketplace.pedido.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

import static java.util.Objects.nonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class PagamentoBoleto extends Pagamento {

    private LocalDate dataPagamento;
    private LocalDate dataVencimento;

    public PagamentoBoleto(PagamentoBoletoDTO p) {
        super(p.getTipoPagamento(), Pedido.get(p.getPedido()));
        this.setId(p.getId());
        this.dataVencimento = nonNull(p.getDataVencimento()) ? p.getDataVencimento() : null;
        this.dataPagamento = nonNull(p.getDataPagamento()) ? p.getDataPagamento() : null;
    }

    public static PagamentoBoleto get(PagamentoBoletoDTO p) {
        return new PagamentoBoleto(p);
    }
}
