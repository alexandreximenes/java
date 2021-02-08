package com.treinamento.testes.api.resources;

import com.treinamento.testes.api.models.Book;
import com.treinamento.testes.api.models.BookDTO;
import com.treinamento.testes.api.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
@RequiredArgsConstructor
public class BookController {

    private BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book created(@RequestBody BookDTO bookDTO){
        return bookService.save(bookDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> findAll(){
        return bookService.findAll();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDTO findById(@PathVariable Long id){
        return bookService.findById(id);
    }

}
