package br.com.perceptron.marketplace.pagamento;

import br.com.perceptron.marketplace.pedido.PedidoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static java.util.Objects.nonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoBoletoDTO {

    private Long id;
    private TipoPagamento tipoPagamento;
    private PedidoDTO pedido;
    private LocalDate dataPagamento;
    private LocalDate dataVencimento;

    public PagamentoBoletoDTO(PagamentoBoleto p) {
        this.id = p.getId();
        this.tipoPagamento = nonNull(p.getTipoPagamento()) ? p.getTipoPagamento() : null;
        this.pedido = nonNull(p.getPedido()) ? PedidoDTO.get(p.getPedido()) : null;
        this.dataPagamento = nonNull(p.getDataPagamento()) ? p.getDataPagamento() : null;
        this.dataVencimento = nonNull(p.getDataVencimento()) ? p.getDataVencimento() : null;
    }

    public static PagamentoBoletoDTO get(PagamentoBoleto p) {
        return new PagamentoBoletoDTO(p);
    }
}
