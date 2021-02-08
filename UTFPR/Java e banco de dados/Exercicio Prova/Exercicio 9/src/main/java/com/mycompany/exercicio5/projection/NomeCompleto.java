package com.mycompany.exercicio5.projection;

import org.springframework.beans.factory.annotation.Value;

public interface NomeCompleto {

    @Value("#{(target.nome)} #{(target.sobreNome)}")
    String getFullName();

    @Value("#{(target.endereco.cidade)}")
    String getCidade();
}
