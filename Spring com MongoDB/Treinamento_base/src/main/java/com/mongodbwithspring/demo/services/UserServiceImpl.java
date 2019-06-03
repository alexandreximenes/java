package com.mongodbwithspring.demo.services;

import com.mongodbwithspring.demo.domain.user.Author;
import com.mongodbwithspring.demo.domain.user.AuthorDTO;
import com.mongodbwithspring.demo.exceptions.ObjectNotFoundException;
import com.mongodbwithspring.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<AuthorDTO> findAll() {
        return userRepository.findAll()
                .parallelStream()
                .filter(Objects::nonNull)
                .map(AuthorDTO::new)
                .sorted(Comparator.comparing(AuthorDTO::getNome))
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDTO findById(String id) {
        return userRepository
                .findById(id)
                .map(AuthorDTO::new)
                .orElseThrow( () -> new ObjectNotFoundException("Usuario não encontrado"));
    }

    @Override
    public AuthorDTO save(AuthorDTO user) {
        Author userObject = new Author(user);
        return new AuthorDTO(userRepository.save(userObject));
    }

    @Override
    public void update(String id, AuthorDTO user) {
        Author userObject = userRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado com ID: " + id));
        userObject.setNome(user.getNome());
        userObject.setEmail(user.getEmail());
        userRepository.save(userObject);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }


    public AuthorDTO findByIdPosts(String id) {
        return userRepository
                .findById(id)
                .map(AuthorDTO::new)
                .orElseThrow( () -> new ObjectNotFoundException("Nenhum post encontrado para este usuário"));
    }
}
