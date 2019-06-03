package br.com.perceptron.marketplace.pagamento;

import br.com.perceptron.marketplace.pedido.PedidoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import static java.util.Objects.nonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoCartaoDTO {

    private Long id;
    private TipoPagamento tipoPagamento;
    private PedidoDTO pedido;
    private Integer quantidadeParcelas;

    public PagamentoCartaoDTO(PagamentoCartao p) {
        this.id = p.getId();
        this.tipoPagamento = nonNull(p.getTipoPagamento()) ? p.getTipoPagamento() : null;
        this.quantidadeParcelas = !StringUtils.isEmpty(p.getQuantidadeParcelas()) ? p.getQuantidadeParcelas() : null;
        this.pedido = nonNull(p.getPedido()) ? PedidoDTO.get(p.getPedido()) : null;
        this.quantidadeParcelas = !StringUtils.isEmpty(p.getQuantidadeParcelas()) ? p.getQuantidadeParcelas() : null;
    }


    public static PagamentoCartaoDTO get(PagamentoCartao p) {
        return new PagamentoCartaoDTO(p);
    }
}
