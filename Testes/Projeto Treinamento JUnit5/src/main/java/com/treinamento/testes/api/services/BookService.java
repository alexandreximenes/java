package com.treinamento.testes.api.services;

import com.treinamento.testes.api.models.Book;
import com.treinamento.testes.api.models.BookDTO;
import com.treinamento.testes.api.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
//@RequiredArgsConstructor(onConstructor=@__(@Autowired))
@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(BookDTO bookDTO) {
        Book book = Book.builder()
                .author(bookDTO.getAuthor())
                .title(bookDTO.getTitle())
                .isbn(bookDTO.getIsbn())
                .build();

        return bookRepository.save(book);
//
//        return BookDTO.builder()
//                .id(book.getId())
//                .author(book.getAuthor())
//                .title(book.getTitle())
//                .isbn(book.getIsbn())
//                .build();


    }

    public List<BookDTO> findAll() {
        return bookRepository.findAll().stream().map(BookDTO::new).collect(Collectors.toList());
    }

    public BookDTO findById(Long id) {
        return bookRepository.findById(id).map(BookDTO::new).orElse(null);
    }
}
