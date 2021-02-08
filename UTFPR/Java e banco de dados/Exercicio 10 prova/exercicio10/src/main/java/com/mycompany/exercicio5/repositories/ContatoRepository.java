package com.mycompany.exercicio5.repositories;

import com.mycompany.exercicio5.domain.Funcionario;
import com.mycompany.exercicio5.projection.CidadeTotal;
import com.mycompany.exercicio5.projection.NomeCidade;
import com.mycompany.exercicio5.projection.NomeCompleto;
import com.mycompany.exercicio5.projection.SemEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByNomeAndIdade(String nome, Integer idade);
    Optional<Funcionario> findByNomeStartingWith(String nome);
    Optional<Funcionario> findByNomeEndingWith(String nome);
    Optional<Funcionario> findByNomeContaining(String nome);
    List<Funcionario> findByIdIn(Collection<Long> ids);
    List<Funcionario> findByIdNotIn(Collection<Long> ids);
    Optional<Funcionario> findByEnderecoCidade(Collection<Long> ids);
    Optional<Funcionario> findFirstBy();
    Optional<Funcionario> findTopBy();
    Optional<Funcionario> findFirst3ByOrderByIdadeAsc();

    @Query(name = "Contato.byNome")
    Optional<Funcionario> findByNome();

    @Query(name = "Contato.byIdade")
    Optional<Funcionario> findByIdade();

    @Query(" SELECT c FROM Funcionario c  " +
            "where c.idade >= 18 " +
            "order by c.nome asc")
    List<Funcionario> findByContatoMaiolrdade();

    @Query("SELECT c from Funcionario c where c.dtCadastro > ?1")
    List<Funcionario> findByDtCadastroAfter(Date dataCadastro);

    Optional<SemEndereco> findContatoByNome(String nome);

    Optional<NomeCidade> findContatoCidadeByNome(String nome);

    Optional<NomeCompleto> findContatoByNomeLikeAndSobreNomeLike(String nomeCompleto);

    @Query("SELECT e.cidade as cidade COUNT(e.cidade) as total " +
            "FROM Cargo e " +
            "GROUP BY e.cidade")
    Optional<CidadeTotal> findByCidadeTotal();
}
