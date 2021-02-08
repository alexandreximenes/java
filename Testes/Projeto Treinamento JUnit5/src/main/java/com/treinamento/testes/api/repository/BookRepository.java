package com.treinamento.testes.api.repository;

import com.treinamento.testes.api.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleIgnoreCaseContaining(String title);
}
