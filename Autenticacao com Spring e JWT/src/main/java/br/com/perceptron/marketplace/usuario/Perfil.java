package br.com.perceptron.marketplace.usuario;

import java.util.Arrays;

public enum Perfil {
    USER(1, "USUARIO"),
    ADMIN(2, "ADMIN"),
    CLIENTE(3, "CLIENTE");

    private int codigo;
    private String descricao;

    Perfil(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static boolean isValid(String perfil) {
        return Arrays.stream(Perfil.values()).anyMatch(p -> p.getDescricao().contains(perfil));
    }
}
