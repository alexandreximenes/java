package com.mycompany.exercicio5.projection;

import org.springframework.beans.factory.annotation.Value;

public interface NomeCidade {
    String getNome();

    @Value("#{(target.cargo.cidade)}")
    String getCidade();
}
