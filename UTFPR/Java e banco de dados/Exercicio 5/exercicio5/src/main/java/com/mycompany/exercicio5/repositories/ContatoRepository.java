package com.mycompany.exercicio5.repositories;

import com.mycompany.exercicio5.domain.Contato;
import com.mycompany.exercicio5.projection.CidadeTotal;
import com.mycompany.exercicio5.projection.NomeCidade;
import com.mycompany.exercicio5.projection.NomeCompleto;
import com.mycompany.exercicio5.projection.SemEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    Optional<Contato> findByNomeAndIdade(String nome, Integer idade);
    Optional<Contato> findByNomeStartingWith(String nome);
    Optional<Contato> findByNomeEndingWith(String nome);
    Optional<Contato> findByNomeContaining(String nome);
    List<Contato> findByIdIn(Collection<Long> ids);
    List<Contato> findByIdNotIn(Collection<Long> ids);
    Optional<Contato> findByEnderecoCidade(Collection<Long> ids);
    Optional<Contato> findFirstBy();
    Optional<Contato> findTopBy();
    Optional<Contato> findFirst3ByOrderByIdadeAsc();

    @Query(name = "Contato.byNome")
    Optional<Contato> findByNome();

    @Query(name = "Contato.byIdade")
    Optional<Contato> findByIdade();

    @Query(" SELECT c FROM Contato c  " +
            "where c.idade >= 18 " +
            "order by c.nome asc")
    List<Contato> findByContatoMaiolrdade();

    @Query("SELECT c from Contato c where c.dtCadastro > ?1")
    List<Contato> findByDtCadastroAfter(Date dataCadastro);

    Optional<SemEndereco> findContatoByNome(String nome);

    Optional<NomeCidade> findContatoCidadeByNome(String nome);

    Optional<NomeCompleto> findContatoByNomeLikeAndSobreNomeLike(String nomeCompleto);

    @Query("SELECT e.cidade as cidade COUNT(e.cidade) as total " +
            "FROM Endereco e " +
            "GROUP BY e.cidade")
    Optional<CidadeTotal> findByCidadeTotal();
}