package br.com.perceptron.marketplace.paginacao;

import br.com.perceptron.marketplace.pagamento.PagamentoBoleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoBoletoRepository extends JpaRepository<PagamentoBoleto, Long> {
}
