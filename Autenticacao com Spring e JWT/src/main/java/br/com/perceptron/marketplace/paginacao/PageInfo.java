package br.com.perceptron.marketplace.paginacao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo {
    private int paginaAtual;
    private int totalDePaginas;
    private Long totalDeElementos;
    private boolean primeiraPagina;
    private boolean ultimaPagina;
    private boolean estaOrdenado;
    private int numeroDeElementos;
    private int quantidade;
    private boolean estaVazia;
}
