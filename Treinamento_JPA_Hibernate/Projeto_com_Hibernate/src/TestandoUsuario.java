import domain.Usuario;
import domain.Veiculo.Veiculo;
import repository.UsuarioRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class TestandoUsuario{

    public static void main(String[] args) {

        UsuarioRepository ur = new UsuarioRepository();

        Optional<Usuario> u = Optional.of(new Usuario());
        u.get().setId(5);

//        Veiculo bmw = new Veiculo("BMW S", LocalDate.now().minusDays(5));
//        u.setVeiculo(bmw);
//
//        ur.save(u);

        u = ur.get(Usuario.class, u.get().getId());

        System.out.println(u);

        //List<Usuario> uGet = ur.list(u);
        //System.out.println(uGet);

    }
}
