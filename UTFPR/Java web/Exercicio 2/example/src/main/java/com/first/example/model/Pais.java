package com.first.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Pais {

    private Long id;
    private String nome;
    private String sigla;
    
}
