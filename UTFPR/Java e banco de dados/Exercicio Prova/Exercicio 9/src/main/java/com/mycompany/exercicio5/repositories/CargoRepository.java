package com.mycompany.exercicio5.repositories;

import com.mycompany.exercicio5.domain.Cargo;
import com.mycompany.exercicio5.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    Cargo findByCargo(String cargo);

    @Transactional(readOnly = true)
    @Query("select c from Cargo c")
    List<Cargo> findAll();

    @Transactional(readOnly = true)
    @Query("select c.cargo from Cargo c")
    List<String> findAllCargos();

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
//     */
//    @Procedure("proc_endereco")
//    public String endereco(@Param("id") Long id);
}
