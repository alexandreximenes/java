package br.com.perceptron.marketplace.categoria;

import br.com.perceptron.marketplace.domains.AbstractEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@CategoriaValidator
@EqualsAndHashCode(callSuper = true)
public class CategoriaDTO extends AbstractEntityDTO {

    @Length(min = 2, max = 255, message = "{not.blank}")
    private String nome;


    public CategoriaDTO(Categoria categoria) {
        this.setId(categoria.getId());
        this.nome = categoria.getNome();
    }

    public static List<CategoriaDTO> get(List<Categoria> categorias) {
        return categorias.stream().map(CategoriaDTO::new).collect(Collectors.toList());
    }

    public static Page<CategoriaDTO> get(Page<Categoria> categorias) {
        return categorias.map(CategoriaDTO::new);
    }
}
