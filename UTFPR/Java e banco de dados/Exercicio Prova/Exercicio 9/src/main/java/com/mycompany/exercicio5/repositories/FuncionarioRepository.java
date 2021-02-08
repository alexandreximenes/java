package com.mycompany.exercicio5.repositories;

import com.mycompany.exercicio5.domain.Funcionario;
import com.mycompany.exercicio5.projection.CidadeTotal;
import com.mycompany.exercicio5.projection.NomeCidade;
import com.mycompany.exercicio5.projection.NomeCompleto;
import com.mycompany.exercicio5.projection.SemEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Funcionario findByNome(String nome);

    @Transactional(readOnly = true)
    @Query("select f from Funcionario f")
    List<Funcionario> findAll();

    @Transactional(readOnly = true)
    @Query("select f.nome from Funcionario f")
    List<String> findAllNomes();

    @Transactional(readOnly = true)
    @Query("select count(f) from Funcionario f")
    Long countAllNomes();

//    Optional<Funcionario> findByNomeAndIdade(String nome, Integer idade);
//    Optional<Funcionario> findByNomeStartingWith(String nome);
//    Optional<Funcionario> findByNomeEndingWith(String nome);
//    Optional<Funcionario> findByNomeContaining(String nome);
//    List<Funcionario> findByIdIn(Collection<Long> ids);
//    List<Funcionario> findByIdNotIn(Collection<Long> ids);
//    Optional<Funcionario> findByEnderecoCidade(Collection<Long> ids);
//    Optional<Funcionario> findFirstBy();
//    Optional<Funcionario> findTopBy();
//    Optional<Funcionario> findFirst3ByOrderByIdadeAsc();
//
//    @Query(name = "Contato.byNome")
//    Optional<Funcionario> findByNome();
//
//    @Query(name = "Contato.byIdade")
//    Optional<Funcionario> findByIdade();
//
//    @Query(" SELECT c FROM Funcionario c  " +
//            "where c.idade >= 18 " +
//            "order by c.nome asc")
//    List<Funcionario> findByContatoMaiolrdade();
//
//    @Query("SELECT c from Funcionario c where c.dtCadastro > ?1")
//    List<Funcionario> findByDtCadastroAfter(Date dataCadastro);
//
//    Optional<SemEndereco> findContatoByNome(String nome);
//
//    Optional<NomeCidade> findContatoCidadeByNome(String nome);
//
//    Optional<NomeCompleto> findContatoByNomeLikeAndSobreNomeLike(String nomeCompleto);
//
//    @Query("SELECT e.cidade as cidade COUNT(e.cidade) as total " +
//            "FROM Cargo e " +
//            "GROUP BY e.cidade")
//    Optional<CidadeTotal> findByCidadeTotal();
//
//    @Query( "select c from Funcionario c where c.idade>= ?1 or c.nome like ?2")
//    List<Funcionario> findByIdadeOuNome(Integer idade, String nome);
//
//    @Query( "select c from Funcionario c where c.idade>= :idade or c.nome like :nome")
//    List<Funcionario> findByIdadeOuNomeComParam(@Param("idade") Integer idade, @Param("nome") String nome);
//
//    @Transactional(readOnly = true)
//    @Modifying
//    @Query("update Cargo e set e.cidade = ?1 where e.id = ?2")
//    int updateCidadeByld(String cidade, Long id);
//
//
//    @Transactional(readOnly = true)
//    @Modifying
//    @Query("delete from Cargo e where e.id =  ?1")
//    int deleteEndereco(Long id);

}
