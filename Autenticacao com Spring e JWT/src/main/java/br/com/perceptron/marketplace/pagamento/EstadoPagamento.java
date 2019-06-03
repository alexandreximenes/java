package br.com.perceptron.marketplace.pagamento;

import java.util.Arrays;

public enum EstadoPagamento {
    PENDENTE(1, "PENDENTE"),
    QUITADO(2, "QUITADO"),
    CANCELADO(3, "CANCELADO");

    private int codigo;
    private String descricao;

    EstadoPagamento(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static boolean codigoIsValid(String descricao) {
        return Arrays.stream(EstadoPagamento.values()).anyMatch(e -> e.getDescricao().contains(descricao));
    }
}
