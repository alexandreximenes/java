package br.com.perceptron.marketplace.pagamento;

public enum TipoPagamento {

    PENDENTE(1, "PENDENTE", "PENDING"),
    QUITADO(2, "QUITADO", "SETTLED"),
    CANCELADO(3, "CANCELADO", "CANCELED");

    private int id;
    private String english, portuguese;

    TipoPagamento(int id, String english, String portuguese) {
        this.id = id;
        this.english = english;
        this.portuguese = portuguese;
    }

    public String EN() {
        return english;
    }

    public String PT() {
        return portuguese;
    }
}
