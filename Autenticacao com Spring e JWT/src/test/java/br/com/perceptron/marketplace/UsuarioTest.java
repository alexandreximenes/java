package br.com.perceptron.marketplace;

import br.com.perceptron.marketplace.usuario.Perfil;
import br.com.perceptron.marketplace.usuario.Usuario;
import br.com.perceptron.marketplace.usuario.UsuarioRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJdbcTest
public class UsuarioTest {

    private UsuarioRepository usuarioRepository;

    @Before
    @Autowired
    public void initUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Test
    public void usuarioReposititoryIsNotNull() {
        Assert.assertNotNull(usuarioRepository);
    }

    @Test
    public void createUser() {
        Set<Perfil> perfil = new HashSet();
        perfil.add(Perfil.USER);
        Usuario u = new Usuario("Alexandre", "x0menes@gmail.com", "tipmuch", true, null, null, perfil);
        usuarioRepository.save(u);
        Assertions.assertThat(u.getId()).isNotNull();
        Assertions.assertThat(u.getNome()).isEqualTo("Alexandre");
        Assertions.assertThat(u.getPassword()).isEqualTo("tipmuch");
    }
}
