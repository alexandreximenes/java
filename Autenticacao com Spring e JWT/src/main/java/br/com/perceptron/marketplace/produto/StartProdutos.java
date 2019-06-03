package br.com.perceptron.marketplace.produto;

import br.com.perceptron.marketplace.categoria.Categoria;
import br.com.perceptron.marketplace.categoria.CategoriaRepository;
import br.com.perceptron.marketplace.response.ResponseDTO;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static br.com.perceptron.marketplace.response.ResponseUtils.*;
import static java.util.Arrays.asList;
import static java.util.Objects.nonNull;

public class StartProdutos {

    private ResponseDTO<Produto> responseDTO = new ResponseDTO<>();

    public StartProdutos(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository) {
        insertData(categoriaRepository, produtoRepository);
    }

    @Transactional
    List<Produto> insertData(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository) {

        List<Produto> produtos = new LinkedList<>();
        try {
            Produto cadeira = new Produto("Cadeira", new BigDecimal("125.30"));
            Categoria imoveis = categoriaRepository.findByNomeContaining("imoveis");
            if (nonNull(imoveis)) cadeira.setCategoria(imoveis);

            Produto mesa = new Produto("Mesa", new BigDecimal("350.00"));
            imoveis = categoriaRepository.findByNomeContaining("imoveis");
            if (nonNull(imoveis)) mesa.setCategoria(imoveis);

            Produto balcao = new Produto("Balcao", new BigDecimal("600.00"));
            imoveis = categoriaRepository.findByNomeContaining("imoveis");
            if (nonNull(imoveis)) balcao.setCategoria(imoveis);

            Produto som = new Produto("Som", new BigDecimal("2200.00"));
            Categoria eletronicosECelulares = categoriaRepository.findByNomeContaining("eletronicos e celulares");
            if (nonNull(imoveis)) som.setCategoria(eletronicosECelulares);

            responseDTO.success($200, PRODUTO + SALVO, this.getClass());

            return produtoRepository.saveAll(asList(cadeira, mesa, balcao, som));

        } catch (Exception e) {
            responseDTO.error($404, NAO_SALVO + PRODUTO, this.getClass(), "insertData", e);
        }

        return null;

    }
}
