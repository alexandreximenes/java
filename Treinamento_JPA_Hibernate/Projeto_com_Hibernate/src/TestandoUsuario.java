import domain.Usuario;
import domain.Veiculo.Veiculo;
import repository.UsuarioRepository;

import java.time.LocalDate;
import java.util.Optional;

import static java.util.Arrays.asList;

public class TestandoUsuario{

    public static void main(String[] args) {

        UsuarioRepository ur = new UsuarioRepository();

        Usuario u = new Usuario();
        u.setNome("Alexandre");
//        u.setId(5);

        Veiculo bmw = new Veiculo("BMW S", LocalDate.now().minusDays(5));
        Veiculo fusca = new Veiculo("fusca", LocalDate.now().minusDays(365));
        u.setVeiculos(asList(bmw, fusca));
        bmw.setUsuario(u);
        fusca.setUsuario(u);
//
        ur.save(u);

        u = ur.get(Usuario.class, u.getId());

        System.out.println(u);

        //List<Usuario> uGet = ur.list(u);
        //System.out.println(uGet);

    }
}
