package com.mycompany.exercicio5.repositories;

import com.mycompany.exercicio5.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Procedure("Usuario.soma")
    Integer procedureSmoa(Integer arg);
}
