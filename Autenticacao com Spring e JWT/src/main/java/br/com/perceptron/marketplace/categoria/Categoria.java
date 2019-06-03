package br.com.perceptron.marketplace.categoria;

import br.com.perceptron.marketplace.domains.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Categoria extends AbstractEntity {
    private String nome;
}
