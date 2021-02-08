package com.treinamento.testes.api.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    private String author;

    public Book(Long id, String title, String isbn, String author) {
        if(title == null)
            throw new RuntimeException("Titulo invalido");
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public void setTitle(String title) {
        if(title == null)
            throw new RuntimeException("Titulo invalido");
        this.title = title;
    }
}
