package com.treinamento.testes;

import com.treinamento.testes.api.models.Book;
import com.treinamento.testes.api.repository.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest(showSql = false)
class TestesApplicationRepository {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @DisplayName("Salvando um livro")
    public void saveBook() {
        Book book = new Book(null, "Junit 5", "123", "Alexandre");
        Book bookSaved = bookRepository.save(book);
        assertThat(bookSaved.getId()).isNotNull();
        assertThat(bookSaved.getTitle()).isEqualTo("Junit 5");
        
    }

    @Test
    @DisplayName("Atualizando um livro")
    public void atualizandoLivro() {
        Book book = new Book(null, "Junit 4", "123", "Alexandre");
        Book bookSaved = bookRepository.save(book);
        book.setTitle("Junit 5");
        book.setAuthor("Alexandre 2");
        bookRepository.save(book);

        assertEquals("Alexandre 2", book.getAuthor());
        assertEquals("Junit 5", book.getTitle());
    }

    @Test
    @DisplayName("Deletando um livro")
    public void deletandoBook() {
        Book book = new Book(null, "Junit 5", "123", "Alexandre");
        Book bookSaved = bookRepository.save(book);
        bookRepository.delete(book);
        assertEquals(Optional.empty(), bookRepository.findById(book.getId()));
//        assertThat(bookRepository.findById(book.getId())).isEqualTo(Optional.empty());
    }

    @Test
    @DisplayName("Buscando livro pelo titulo")
    public void buscandoLivro() {
        Book book1 = new Book(null, "Junit 4", "123", "Alexandre");
        Book book2 = new Book(null, "Junit 5", "1234", "Alexandre");
        bookRepository.saveAll(asList(book1, book2));
        List<Book> books = bookRepository.findByTitleIgnoreCaseContaining("junit");

        assertEquals(2, books.size());
    }


    @Test
    @DisplayName("Lança exceção se o livro não tiver nome")
    public void lancandoExceptionLivroSemNome() {

        RuntimeException runtimeException = org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> new Book(null, null, "123", "Alexandre"));
        assertEquals("Titulo invalido", runtimeException.getMessage());

    }

}
