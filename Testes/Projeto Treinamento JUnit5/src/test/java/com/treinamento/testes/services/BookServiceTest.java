package com.treinamento.testes.services;

import com.treinamento.testes.api.models.Book;
import com.treinamento.testes.api.models.BookDTO;
import com.treinamento.testes.api.repository.BookRepository;
import com.treinamento.testes.api.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("tests")
public class BookServiceTest {

    BookService bookService;

    @MockBean
    BookRepository bookRepository;

    @BeforeEach
    public void setUp(){
        bookService = new BookService(bookRepository);
    }

    @Test
    @DisplayName("Deve salvar um livro")
    public void saveBook(){

        BookDTO bookDTO = BookDTO.builder().title("JUnit 5").author("Alexandre").isbn("12345").build();
        Book book = Book.builder().title("JUnit 5").author("Alexandre").isbn("12345").build();
        Book savedBook = Book.builder().id(2L).title("JUnit 5").author("Alexandre").isbn("12345").build();

        Mockito.when(bookService.save(Mockito.any(BookDTO.class))).thenReturn(savedBook);

        Book bookReturn = bookService.save(bookDTO);

        assertNotNull(bookReturn.getId());
        assertEquals(savedBook.getId(), bookReturn.getId());
        assertEquals(book.getIsbn(), bookReturn.getIsbn());
        assertEquals( book.getTitle(), bookReturn.getTitle());
        assertEquals( book.getAuthor(), bookReturn.getAuthor());
    }
}
