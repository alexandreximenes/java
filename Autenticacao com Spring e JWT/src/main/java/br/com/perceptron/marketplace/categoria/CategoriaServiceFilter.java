package br.com.perceptron.marketplace.categoria;

import static java.util.Objects.nonNull;

public class CategoriaServiceFilter {

    public static Categoria get(Categoria c, CategoriaDTO categoriaDTO) {

        Categoria categoria = null;
        if (nonNull(c)) {
            categoria = c;
        } else {
            categoria = new Categoria();
        }

        categoria.setNome(categoriaDTO.getNome());

        return categoria;
    }
}
