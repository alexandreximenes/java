import domain.Endereco;
import domain.EstadoCivil;
import domain.PalavrasInocentes;
import domain.Usuario;
import repository.PalavrasInocentesRepository;
import repository.UsuarioRepository;

import java.util.Calendar;

import static java.util.Arrays.asList;

public class Principal {

    public static void main(String[] args) {
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        PalavrasInocentesRepository palavrasInocentesRepository = new PalavrasInocentesRepository();

        Usuario user = new Usuario();
        user.setId(3);
//        user.setNome("Wanderley Ximenes");
//        user.setEstadoCivil(EstadoCivil.CASADO);
//        user.setNascimento(Calendar.getInstance());
//
//        Endereco endereco = new Endereco();
//        endereco.setRua("Rua Nova aurora");
//        endereco.setNumero(55);
//        endereco.setCidade("Curitiba");
//
//        user.setEndereco(endereco);
//        usuarioRepository.save(user);

        PalavrasInocentes p = new PalavrasInocentes();
                p.setPalavra("");
                p.setPalavraPronunciada("");
                p.setUsuario(user);

        palavrasInocentesRepository.save(p);
        user.setPalavrasInocentes(asList(p));



//        usuarioRepository.update(user);

//        usuarioRepository.delete(user);
//        usuarioRepository.list(user);
    }
}
