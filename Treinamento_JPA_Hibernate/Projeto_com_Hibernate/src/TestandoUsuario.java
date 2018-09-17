import domain.Usuario;
import repository.UsuarioRepository;

import java.util.List;

public class TestandoUsuario{

    public static void main(String[] args) {

        UsuarioRepository ur = new UsuarioRepository();

        Usuario u = new Usuario();
        u.setId(1);

        List<Usuario> uGet = ur.list(u);

        System.out.println(uGet);

    }
}
