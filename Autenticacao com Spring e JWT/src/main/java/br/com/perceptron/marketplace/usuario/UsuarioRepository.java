package br.com.perceptron.marketplace.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);

    @Query("FROM Usuario u WHERE u.username = :_username and u.password = :_password and u.ativo = 1")
    Optional<Usuario> findCredentials(@Param("_username") String username, @Param("_password") String password);

    @Query("SELECT u FROM Usuario u WHERE u.ativo = 1")
    List<Usuario> findAllAtivos();
}
