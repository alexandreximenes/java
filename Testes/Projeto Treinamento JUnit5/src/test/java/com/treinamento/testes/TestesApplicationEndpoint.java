package com.treinamento.testes;

import com.treinamento.testes.api.models.Book;
import com.treinamento.testes.api.models.BookDTO;
import com.treinamento.testes.api.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Arrays.asList;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestesApplicationEndpoint {

    private static final String BOOK_API = "/api/books";
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private BookRepository bookRepository;

    @TestConfiguration
    static class Config {
        @Bean
        public RestTemplateBuilder restTemplateBuilder() {
            return new RestTemplateBuilder();
        }

    }

    @Test
    @DisplayName("Listar todos os livros")
    void listarTodosOsLivros() {

        List<Book> books = asList(new Book(), new Book(), new Book(), new Book(), new Book() );
        BDDMockito.when(bookRepository.findAll()).thenReturn(books);
        ResponseEntity<String> response = restTemplate.getForEntity(BOOK_API, String.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @DisplayName("Buscar livro por id")
    public void buscarPorId(){

        Book book = new Book(1L, "Junit 5", "123", "Alex");

        BDDMockito
                .when(bookRepository.findById(book.getId()))
                .thenReturn(Optional.ofNullable(book));

        ResponseEntity<BookDTO> response = restTemplate.getForEntity(BOOK_API + "/{id}", BookDTO.class, book.getId());

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertNotNull(response.getBody());
        Assertions.assertEquals(1L, response.getBody().getId());
        Assertions.assertEquals("Junit 5", response.getBody().getTitle());
    }

    @Test
    @DisplayName("Buscar livro que não existe")
    public void buscarPorIdQueNaoExiste(){

        ResponseEntity<BookDTO> response = restTemplate.getForEntity(BOOK_API + "/{id}", BookDTO.class, -100L);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }

}
