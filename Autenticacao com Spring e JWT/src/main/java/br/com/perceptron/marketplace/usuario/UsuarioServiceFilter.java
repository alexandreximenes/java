package br.com.perceptron.marketplace.usuario;

import br.com.perceptron.marketplace.exceptions.FieldEmptyException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsuarioServiceFilter {

    public static Usuario get(Usuario usuario, UsuarioDTO usuarioDTO, BCryptPasswordEncoder bCryptPasswordEncoder) {

        Usuario u = null;

        if (nonNull(usuario)) {
            u = usuario;
        } else {
            u = new Usuario();
            u.setAtivo(true);
            if (isNull(usuarioDTO.getPassword())) {
                throw new FieldEmptyException("Por favor, informe o seu password.");
            } else {
                u.setPassword(bCryptPasswordEncoder.encode(usuarioDTO.getPassword()));
            }
            if (usuarioDTO.getPerfis().isEmpty()) {
                Set<Perfil> perfis = new HashSet<>();
                perfis.add(Perfil.USER);
                u.setPerfis(perfis);
            }
        }

        if (!StringUtils.isEmpty(usuarioDTO.getNome())) {
            u.setNome(usuarioDTO.getNome());
        }
        if (!StringUtils.isEmpty(usuarioDTO.getUsername())) {
            u.setUsername(usuarioDTO.getUsername());
        }
        if (!StringUtils.isEmpty(usuarioDTO.getPerfis())) {
            u.setPerfis(usuarioDTO.getPerfis());
        }
        if (nonNull(usuarioDTO.getAtivo()) && isValidActive(usuarioDTO.getAtivo())) {
            u.setAtivo(usuarioDTO.getAtivo());
        }

        return u;
    }

    private static boolean isValidActive(boolean ativo) {
        return !StringUtils.isEmpty(ativo) && ativo;
    }
}
