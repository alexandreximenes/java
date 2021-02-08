package com.mycompany.exercicio5.repositories;

import com.mycompany.exercicio5.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Cargo, Long> {
}
