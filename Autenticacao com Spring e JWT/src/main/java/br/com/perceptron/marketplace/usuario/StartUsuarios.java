package br.com.perceptron.marketplace.usuario;

import br.com.perceptron.marketplace.response.ResponseDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static br.com.perceptron.marketplace.response.ResponseUtils.*;

public class StartUsuarios {

    private ResponseDTO<Usuario> responseDTO = new ResponseDTO<>();

    public StartUsuarios(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        insertData(usuarioRepository, bCryptPasswordEncoder);
    }

    @Transactional
    void insertData(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {

        try {
            Set<Perfil> perfis = new HashSet<>();
            perfis.add(Perfil.USER);
            perfis.add(Perfil.ADMIN);
            Optional<Usuario> alexandre = usuarioRepository.findByUsername("xyymenes@gmail.com");
            Optional<Usuario> admin = usuarioRepository.findByUsername("admin@admin.com");

            if (!alexandre.isPresent()) {
                usuarioRepository.save(new Usuario("alexandre", "xyymenes@gmail.com", bCryptPasswordEncoder.encode("alexandre"), true, null, LocalDateTime.now(), perfis));
            }
            if (!admin.isPresent()) {
                usuarioRepository.save(new Usuario("admin", "admin@admin.com", bCryptPasswordEncoder.encode("admin"), true, null, LocalDateTime.now(), perfis));
            }
            responseDTO.success($200, USUARIO + SALVO, this.getClass());
        } catch (Exception e) {
            responseDTO.error($404, NAO_SALVO + USUARIO, this.getClass(), "insertData", e);
        }

    }
}
