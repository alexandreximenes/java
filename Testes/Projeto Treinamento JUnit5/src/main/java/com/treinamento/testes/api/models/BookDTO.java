package com.treinamento.testes.api.models;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO implements Serializable {

    private Long id;
    private String title;
    private String isbn;
    private String author;


    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.isbn = book.getIsbn();
        this.author = book.getAuthor();
    }
}
