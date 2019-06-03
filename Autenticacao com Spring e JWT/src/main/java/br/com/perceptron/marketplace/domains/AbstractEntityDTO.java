package br.com.perceptron.marketplace.domains;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class AbstractEntityDTO implements Serializable, IDomain {

    private static final long serialVersionUID = 1L;
    @EqualsAndHashCode.Include
    private Long id;
}
