package br.com.perceptron.marketplace.paginacao;

import br.com.perceptron.marketplace.pagamento.PagamentoCartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoCartaoRepository extends JpaRepository<PagamentoCartao, Long> {
}
