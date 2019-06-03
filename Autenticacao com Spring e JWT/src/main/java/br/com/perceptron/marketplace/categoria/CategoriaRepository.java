package br.com.perceptron.marketplace.categoria;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Categoria findByNomeContaining(String categoria);

    @Query("SELECT c FROM Categoria c WHERE c.nome LIKE %:parametro% OR c.id LIKE %:parametro%")
    Page<Categoria> findAll(@Param("parametro") String parametro, Pageable pageable);
}
