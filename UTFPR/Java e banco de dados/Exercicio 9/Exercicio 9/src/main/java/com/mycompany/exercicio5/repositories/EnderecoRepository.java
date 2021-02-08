package com.mycompany.exercicio5.repositories;

import com.mycompany.exercicio5.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {


    /**
     * CREATE PROCEDURE proc_endereco(IN in_id BIGINT, OUT endereco VARCHAR(254))
     * READS SQL DATA
     * BEGIN ATOMIC
     *    SELECT CONCAT(logradouro, ', ', cidade, ', ', estado, '.')
     *    INTO endereco
     *    FROM ENDERECOS WHERE id = in_id;
     * END;
     * @param id
     * @return
     */
    @Procedure("proc_endereco")
    public String endereco(@Param("id") Long id);
}
