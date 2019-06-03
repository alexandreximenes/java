package br.com.perceptron.marketplace.usuario;

import br.com.perceptron.marketplace.email.Email;
import br.com.perceptron.marketplace.email.EmailNotification;
import br.com.perceptron.marketplace.exceptions.MConstraintViolationException;
import br.com.perceptron.marketplace.exceptions.MDataIntegrityViolationException;
import br.com.perceptron.marketplace.exceptions.ObjectNotFoundException;
import br.com.perceptron.marketplace.response.ResponseDTO;
import br.com.perceptron.marketplace.security.JWTUtil;
import br.com.perceptron.marketplace.security.SecurityUtils;
import br.com.perceptron.marketplace.security.UserSecurity;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static br.com.perceptron.marketplace.domains.AbstractEntity.codeIDisValid;
import static br.com.perceptron.marketplace.response.ResponseUtils.*;
import static br.com.perceptron.marketplace.security.Headers.AUTHORIZATION;
import static br.com.perceptron.marketplace.security.Headers.BEARER;
import static br.com.perceptron.marketplace.usuario.UsuarioDTO.get;
import static java.util.Objects.nonNull;

@Service
public class UsuarioService {

    private ResponseDTO<Object> responseDTO = new ResponseDTO<>();

    @Autowired
    private UsuarioRepository userRepository;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private EmailNotification emailNotification;


    public ResponseEntity<Object> findById(Long id) {
        Usuario usuario = find(id);
        return responseDTO.success($200, objectNotFound(messageSource), new UsuarioDTO(usuario), this.getClass());
    }

    public Usuario find(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(objectNotFound(messageSource)));
    }

    public ResponseEntity<Object> findAll() {
        List<Usuario> usuarios = userRepository.findAll();
        return responseObjects(usuarios);
    }

    public ResponseEntity<Object> findAllAtivos() {
        List<Usuario> usuarios = userRepository.findAllAtivos();
        return responseObjects(usuarios);
    }

    private ResponseEntity<Object> responseObjects(List<Usuario> usuarios) {
        if (!usuarios.isEmpty()) {
            List<UsuarioDTO> usuariosDTO = get(usuarios);
            return responseDTO.success($200, searchOk(messageSource), usuariosDTO, this.getClass());
        }
        throw new ObjectNotFoundException(objectNotFound(messageSource));
    }

    public ResponseEntity<Object> deleteById(Long id) {
        if (codeIDisValid(id)) {
            Usuario usuario = find(id);
            userRepository.deleteById(usuario.getId());
        }
        return responseDTO.success($200, objectRemoved(messageSource), this.getClass());
    }

    public ResponseEntity<Object> saveOrUpdate(UsuarioDTO usuarioDTO) {
        Usuario usuario = null;
        try {
            if (nonNull(usuarioDTO.getId())) {
                usuario = find(usuarioDTO.getId());
            }

            usuario = UsuarioServiceFilter.get(usuario, usuarioDTO, bCryptPasswordEncoder);
            usuario = userRepository.save(usuario);
            return responseDTO.success($200, objectSaved(messageSource), new UsuarioDTO(usuario), this.getClass());

        } catch (MDataIntegrityViolationException e) {
            throw new MDataIntegrityViolationException(e.getMessage());
        } catch (MConstraintViolationException e) {
            throw new MConstraintViolationException(objectWithRelationship(messageSource));
        }
    }

    public ResponseEntity<Object> authentication(LoginDTO login) {
        Usuario usuario = userRepository.findCredentials(login.getUsername(), login.getPassword())
                .orElseThrow(() -> new ObjectNotFoundException(objectNotFound(messageSource)));

        return responseDTO.success($200, searchOk(messageSource), new UsuarioDTO(usuario), this.getClass());
    }

    public ResponseEntity<Object> findTokenToCurrentUser() {
        Usuario usuario = null;
        UserSecurity userPrincipal = UserSecurity.getUserPrincipal();
        if (nonNull(userPrincipal))
            usuario = userRepository.findById(userPrincipal.getId()).orElseThrow(() -> new ObjectNotFoundException(objectNotFound(messageSource)));
        if (nonNull(usuario))
            return responseDTO.success($200, searchOk(messageSource), new UsuarioDTO(usuario), this.getClass());
        return responseDTO.error($404, objectNotFound(messageSource), this.getClass(), "findTokenToCurrentUser", null);
    }

    public ResponseEntity<Object> refreshToken(HttpServletResponse response) {
        UserSecurity userPrincipal = UserSecurity.getUserPrincipal();
        Claims claims = null;
        if (nonNull(userPrincipal)) {
            claims = jwtUtil.refreshToken(userPrincipal.getUsername());
            response.addHeader(AUTHORIZATION, BEARER + claims.getSubject());

        }
        return responseDTO.success($200, refreshTokenMessage(messageSource), new TokenDTO(claims), this.getClass());
    }

    public ResponseEntity<Object> sendNewPassword(String email) {
        String newPassword = generateNewPassword(email);
        Email emailSender = new Email();
        emailNotification.sendSimpleMailMessage(emailSender);
        return responseDTO.success($200, sendNewPasswordByEmail(messageSource), newPassword, this.getClass());
    }

    private String generateNewPassword(String email) {

        Usuario usuario = userRepository
                .findByUsername(email)
                .orElseThrow(() -> new ObjectNotFoundException(userNotFound(messageSource)));

        String newPassword = SecurityUtils.newPassword();

        usuario.setPassword(bCryptPasswordEncoder.encode(newPassword));
        userRepository.save(usuario);

        return newPassword;
    }
}
