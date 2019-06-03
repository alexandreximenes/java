package br.com.perceptron.marketplace.security;

import br.com.perceptron.marketplace.usuario.Usuario;
import br.com.perceptron.marketplace.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import static br.com.perceptron.marketplace.response.ResponseUtils.objectNotFound;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailServiceImpl implements UserDetailsService {

    private final MessageSource messageSource;
    private final UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Usuario usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> new br.com.perceptron.marketplace.exceptions.UsernameNotFoundException(objectNotFound(messageSource)));
        return new UserSecurity(usuario.getId(), usuario.getUsername(), usuario.getPassword(), usuario.getPerfis());
    }
}
